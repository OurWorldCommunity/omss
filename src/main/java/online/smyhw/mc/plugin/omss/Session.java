package online.smyhw.mc.plugin.omss;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Session {

    public Session(String player_id){
        this.playerId = player_id;
        this.status = 1;
        this.sessionId = Session.generateSessionId(64);
        Session.Session_list.put(this.sessionId,this);
    }

    public static Map<String,Session> Session_list = new ConcurrentHashMap<String,Session>();

    //随机密钥，会话id
    public String sessionId;

    //玩家ID
    public String playerId;

    /**
     * 状态
     * 1 = 等待玩家上传皮肤文件
     * 2 = 皮肤文件已上传，等待皮肤更改完成
     * 3 = 皮肤更改已经完成，前端标签页应主动关闭
     */
    public Integer status;

    //皮肤文件
    public byte[] skin_file;


    /**
     * 生成随机id
     * @param length id长度
     * @return 生成的id
     */
    public static String generateSessionId(int length) {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

}
