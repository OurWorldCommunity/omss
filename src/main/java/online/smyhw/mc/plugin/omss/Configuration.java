package online.smyhw.mc.plugin.omss;


import online.smyhw.mc.plugin.omss.webServer.StaticHandler;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Configuration {
    public int http_port=80;

    public String public_prefix = "https://example.com:8765/";

    public Configuration(String file_path) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(file_path);
        properties.load(inputStream);

        this.http_port= Integer.parseInt(properties.getOrDefault("http_port",80)+"");
        this.public_prefix= properties.getOrDefault("public_prefix","https://example.com:8765/")+"";
    }

    /**
     * 向指定位置释放jar包中的配置文件
     * @param path 释放位置
     * @throws IOException 任何异常都将抛出给上游
     */
    public static void  releaseNewConfig(String path) throws IOException, URISyntaxException {
        //若目录不存在，创建之
        Path outputDirPath = Paths.get(path).getParent();
        if (outputDirPath != null) {
            Files.createDirectories(outputDirPath);
        }
        //创建空文件
        File outputFile = new File(path);
        outputFile.createNewFile();
        //写入
        String jarPath = StaticHandler.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        ZipFile jarFile = new ZipFile(jarPath);
        ZipEntry zipEntry = jarFile.getEntry("omss_config.properties");
        InputStream inputStream = jarFile.getInputStream(zipEntry);
        try (OutputStream outputStream = new FileOutputStream(path)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
