package online.smyhw.mc.plugin.omss.webServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import online.smyhw.mc.plugin.omss.Session;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Utils {
    public static void init(int port) throws java.io.IOException, URISyntaxException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new StaticHandler());
        server.createContext("/api/session", new SessionHandler());
        server.createContext("/api/skin_file/", new SkinFileHandler());
        // httpserver.setExecutor(null); //使用单线程
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
    }

    public static void return_json(String msg,HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        byte[] responseBytes = msg.getBytes("UTF-8");
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, responseBytes.length);
        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(responseBytes);
        outputStream.close();
    }

    public static Session verify(HttpExchange exchange) {

        URI uri = exchange.getRequestURI();
        String query = uri.getQuery();

        if (query == null) {
            return null;
        }

        String[] parameters = query.split("&");

        for (String parameter : parameters) {
            String[] keyValue = parameter.split("=");

            if (keyValue.length == 2 && keyValue[0].equals("session")) {
                String value = keyValue[1];
                return Session.Session_list.get(value);
            }
        }
        return null;
    }

    public static byte[] getFileBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream fileBytes = new ByteArrayOutputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int read;
        byte[] data = new byte[1024];

        // Read input stream into buffer
        while ((read = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, read);
        }

        byte[] bufferBytes = buffer.toByteArray();
        int fileContentStart = -1;
        int fileContentEnd = -1;

        // Find the file content start and end position
        byte[] fileContentStartDelimiter = "\r\n\r\n".getBytes(StandardCharsets.UTF_8);
        byte[] fileContentEndDelimiter = "\r\n------".getBytes(StandardCharsets.UTF_8);

        // Search for start and end delimiters in the buffer
        for (int i = 0; i < bufferBytes.length; i++) {
            if (fileContentStart == -1) {
                // Check if the bytes at the current position match the start delimiter
                boolean matchStart = true;
                for (int j = 0; j < fileContentStartDelimiter.length && matchStart && i + j < bufferBytes.length; j++) {
                    if (bufferBytes[i + j] != fileContentStartDelimiter[j]) {
                        matchStart = false;
                    }
                }
                if (matchStart) {
                    fileContentStart = i + fileContentStartDelimiter.length;
                }
            }

            if (fileContentStart != -1 && fileContentEnd == -1) {
                // Check if the bytes at the current position match the end delimiter
                boolean matchEnd = true;
                for (int j = 0; j < fileContentEndDelimiter.length && matchEnd && i + j < bufferBytes.length; j++) {
                    if (bufferBytes[i + j] != fileContentEndDelimiter[j]) {
                        matchEnd = false;
                    }
                }
                if (matchEnd) {
                    fileContentEnd = i;
                    break;
                }
            }
        }

        if (fileContentStart != -1 && fileContentEnd != -1) {
            // Extract file content
            int fileContentLength = fileContentEnd - fileContentStart;
            fileBytes.write(bufferBytes, fileContentStart, fileContentLength);
        }

        return fileBytes.toByteArray();
    }


    /**
     * 测试
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        init(8880);
        while (true) {
            sleep(10);
        }
    }





}