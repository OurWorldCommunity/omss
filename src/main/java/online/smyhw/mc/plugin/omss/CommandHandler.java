package online.smyhw.mc.plugin.omss;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;

public final class CommandHandler implements SimpleCommand {

    @Override
    public void execute(final Invocation invocation) {
        CommandSource source = invocation.source();
        // Get the arguments after the command alias
        String[] args = invocation.arguments();
        String playerName = "";
        if (source instanceof Player) {
            playerName = ((Player)source).getUsername();
        }else{
            source.sendMessage(Component.text("控制台没有皮肤(").color(NamedTextColor.LIGHT_PURPLE));
        }
        Session se = new Session(playerName);
        Component res = Component.text()
                .content("皮肤更新会话已创建，点击这里打开！")
                .color(NamedTextColor.AQUA).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL,Omss.config.public_prefix+"?session="+se.sessionId)).build();
        source.sendMessage(res);
    }

    @Override
    public boolean hasPermission(final Invocation invocation) {
        return invocation.source().hasPermission("omss.use");
    }

}