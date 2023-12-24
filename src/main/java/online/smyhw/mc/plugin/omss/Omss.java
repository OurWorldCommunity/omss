package online.smyhw.mc.plugin.omss;

import com.google.inject.Inject;
import com.velocitypowered.api.command.BrigadierCommand;
import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.command.CommandMeta;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.skinsrestorer.api.SkinsRestorer;
import net.skinsrestorer.api.SkinsRestorerProvider;
import net.skinsrestorer.api.connections.MineSkinAPI;
import net.skinsrestorer.api.connections.model.MineSkinResponse;
import net.skinsrestorer.api.exception.DataRequestException;
import net.skinsrestorer.api.exception.MineSkinException;
import net.skinsrestorer.api.property.InputDataResult;
import net.skinsrestorer.api.property.SkinProperty;
import net.skinsrestorer.api.storage.PlayerStorage;
import net.skinsrestorer.api.storage.SkinStorage;
import online.smyhw.mc.plugin.omss.webServer.Utils;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Optional;

import static online.smyhw.mc.plugin.omss.Configuration.releaseNewConfig;

@Plugin(
        id = "omss",
        name = "OMSS",
        version = "v1.0",
        description = "唔，拓展skinsrestorer，提供一个网页以上传皮肤文件",
        url = "smyhw.online/omss",
        authors = {"smyhw"},
        dependencies = {
                @Dependency(id = "skinsrestorer", optional = true)
        }
)
public class Omss {
    public static Configuration config;
    public static Logger logger;
    static ProxyServer server;
    static Path dataDirectory;

    @Inject
    public Omss(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory) {
        Omss.server = server;
        Omss.logger = logger;
        Omss.dataDirectory = dataDirectory;
    }



    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("OMSS初始化,读取配置文件...");
        String cfg_path = dataDirectory.toString()+"/config.properties";
        //若配置文件不存在，写入
        File file = new File(cfg_path);
        if (!file.exists()) {
            logger.warn("配置文件不存在,释放新配置文件...");
            try {
                releaseNewConfig(cfg_path);
            } catch (Exception e) {
                logger.error("释放配置文件异常,中止初始化!!!");
                throw new RuntimeException(e);
            }
        }
        try {
            config = new Configuration(cfg_path);
        } catch (IOException e) {
            logger.error("配置文件异常,中止初始化!!!");
            throw new RuntimeException(e);
        }
        logger.info("启动web端口<"+config.http_port+">...");
        try {
            Utils.init(config.http_port);
        } catch (Exception e) {
            logger.error("启动web端口异常,中止初始化!!!");
            throw new RuntimeException(e);
        }
        logger.info("注册指令...");
        CommandManager commandManager = server.getCommandManager();
        CommandMeta commandMeta = commandManager.metaBuilder("omss").plugin(this).build();
        SimpleCommand commandToRegister = new CommandHandler();
        commandManager.register(commandMeta, commandToRegister);
        logger.info("初始化完成!");
    }

    @Subscribe
    public void onPlayerQuit(DisconnectEvent event) {
        String playerId = event.getPlayer().getUsername();
        for (String oneSession : Session.Session_list.keySet()){
            if (Session.Session_list.get(oneSession).playerId.equals(playerId)){
                Session.Session_list.remove(oneSession);
            }
        }
    }

    public static boolean changeSkin(Session session) throws MineSkinException, DataRequestException {
        Optional<Player> player =  server.getPlayer(session.playerId);
        if(player.isEmpty()){
            return false;
        }

        Player r_player = player.get();

        SkinsRestorer skinsRestorerAPI = SkinsRestorerProvider.get();

        PlayerStorage playerStorage = skinsRestorerAPI.getPlayerStorage();
        MineSkinAPI mineSkinAPI = skinsRestorerAPI.getMineSkinAPI();
        logger.info("玩家<"+r_player.getUsername()+">皮肤请求地址 -> "+config.public_prefix+"api/skin_file/get/"+session.sessionId+".png");
        MineSkinResponse mineSkinResponse = mineSkinAPI.genSkin(config.public_prefix+"api/skin_file/get/"+session.sessionId+".png",null);
        SkinProperty skinProperty = mineSkinResponse.getProperty();

        SkinStorage skinStorage = skinsRestorerAPI.getSkinStorage();
        skinStorage.setCustomSkinData(session.playerId, skinProperty);
        Optional<InputDataResult> result = skinStorage.findOrCreateSkinData(session.playerId);
        playerStorage.setSkinIdOfPlayer(r_player.getUniqueId(), result.get().getIdentifier());
        skinsRestorerAPI.getSkinApplier(Player.class).applySkin(r_player);
        logger.info("玩家<"+r_player.getUsername()+">皮肤更改完成");
        return true;
    }
}
