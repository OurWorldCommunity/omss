package online.smyhw.mc.plugin.omss.webServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import online.smyhw.mc.plugin.omss.Session;

import java.io.*;

import static online.smyhw.mc.plugin.omss.webServer.Utils.return_json;

public class SessionHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Session session = Utils.verify(exchange);

        String jsonResponse;
        if(session==null){
            jsonResponse = "{" +
                    "\"Status\":-1"+
                    "}";
        }else{
            jsonResponse = "{" +
                    "\"PlayerId\": \""+session.playerId+"\"," +
                    "\"Status\":" + session.status+
                    "}";
        }
        return_json(jsonResponse,exchange);
    }

}
