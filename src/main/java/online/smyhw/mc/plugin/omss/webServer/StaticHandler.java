package online.smyhw.mc.plugin.omss.webServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class StaticHandler implements HttpHandler {
    private static ZipFile jarFile;
    public StaticHandler() throws IOException, URISyntaxException {
        String jarPath = StaticHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        jarFile = new ZipFile(jarPath);

    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        if(path.equals("/")){
            path = "/index.html";
        }
        if(path.endsWith(".js")){
            exchange.getResponseHeaders().set("Content-Type", "text/javascript");
        } else if (path.endsWith(".css")) {
            exchange.getResponseHeaders().set("Content-Type", "text/css");
        } else if (path.endsWith(".ico")) {
            exchange.getResponseHeaders().set("Content-Type", "image/x-icon");
        }
        byte[] responseBytes = readStaticFile(path);
        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.close();
    }

    public static byte[] readStaticFile(String path) throws IOException {

        ZipEntry zipEntry  = jarFile.getEntry("web"+path);
        InputStream inputStream = null;
        try{
            inputStream = jarFile.getInputStream(zipEntry);
        }catch( Exception e ){
            return "这里什么也没有喵~".getBytes(StandardCharsets.UTF_8);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        return outputStream.toByteArray();
    }
}
