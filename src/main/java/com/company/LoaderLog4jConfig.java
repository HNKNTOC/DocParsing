package com.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Настраивает библиотеке Log4j.
 */
public class LoaderLog4jConfig {
    private static ClassLoader loader = LoaderLog4jConfig.class.getClassLoader();

    /**
     * Указывает библиотеке Log4j конфигурационный файл Log4j2.xml
     */
    public static void loadConfig() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        try {
            URI configLocation = loader.getResource("Log4j2.xml").toURI();
            context.setConfigLocation(configLocation);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
