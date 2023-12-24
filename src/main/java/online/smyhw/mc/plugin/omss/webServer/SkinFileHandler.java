package online.smyhw.mc.plugin.omss.webServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import net.skinsrestorer.api.exception.DataRequestException;
import net.skinsrestorer.api.exception.MineSkinException;
import online.smyhw.mc.plugin.omss.Omss;
import online.smyhw.mc.plugin.omss.Session;

import java.io.*;
import java.net.HttpURLConnection;

import static online.smyhw.mc.plugin.omss.webServer.Utils.getFileBytesFromInputStream;
import static online.smyhw.mc.plugin.omss.webServer.Utils.return_json;

/**
 * 处理上传皮肤文件，并提供下载url
 */
public class SkinFileHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try{
            //获取链接不需要token
            if(exchange.getRequestURI().getPath().startsWith("/api/skin_file/get/")
                    && exchange.getRequestURI().getPath().endsWith(".png")){
                exchange.getResponseHeaders().set("Content-Type", "image/png");
                get_skin(exchange);
                return;
            }

            Session session = Utils.verify(exchange);
            if(session==null){
                String jsonResponse = "{" +
                        "\"Status\":-1"+
                        "}";
                return_json(jsonResponse,exchange);
                return;
            }
            if(exchange.getRequestURI().getPath().equals("/api/skin_file/set")){
                set_skin(session,exchange);
                return;
            }

            return_json(":((",exchange);
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    void get_skin(HttpExchange exchange) throws IOException {
        String session_id = exchange.getRequestURI().getPath().substring(19,exchange.getRequestURI().getPath().length()-4);
        Session session = Session.Session_list.get(session_id);
        if(session==null){
            String msg = "{" +
                    "\"Status\":-4"+
                    "}";
            return_json(msg,exchange);
            return;
        }
        if(session.skin_file.length==0){
            String msg = "{" +
                    "\"Status\":-7"+
                    "}";
            return_json(msg,exchange);
            return;
        }
        // 响应头
        exchange.getResponseHeaders().set("Content-Type", "image/png");
        exchange.getResponseHeaders().set("Content-Disposition", "attachment; filename=" + session_id+".png");

        // 文件长度
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, session.skin_file.length);

        //实际文件
        OutputStream responseStream = exchange.getResponseBody();
        responseStream.write(session.skin_file);
        responseStream.close();
    }

    boolean set_skin(Session session,HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            return_json(":(",exchange);
            return false;
        }
        // 获取上传文件的大小
        long contentLength = Long.parseLong(exchange.getRequestHeaders().getFirst("Content-length"));
        // 文件大小超过限制,64kb应该足以上传任何皮肤了
        if (contentLength > (64*1024)) {
            String msg = "{" +
                        "\"Status\":-2"+
                    "}";
            return_json(msg,exchange);

            return false;
        }

        // 获取上传文件的输入流
        InputStream inputStream = exchange.getRequestBody();
        session.skin_file = getFileBytesFromInputStream(inputStream);;
        String msg = "{" +
                "\"Status\":1"+
                "}";
        session.status=2;
        //应用皮肤
        try {
            Boolean re = Omss.changeSkin(session);
            if(!re){
                //玩家不存在（不在线）
                msg = "{" +
                        "\"Status\":-8"+
                        "}";
                return_json(msg,exchange);
                return false;
            }
        } catch (MineSkinException e) {
            msg = "{" +
                    "\"Status\":-10"+
                    "}";
            Omss.logger.warn("MineSkin错误 -> ",e);
        } catch (DataRequestException e) {
            msg = "{" +
                    "\"Status\":-11"+
                    "}";
            Omss.logger.warn("DataRequest错误 -> ",e);
        }
        return_json(msg,exchange);
        session.status=3;
        return true;
    }

}
