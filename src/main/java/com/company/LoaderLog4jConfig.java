package com.company;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

/**
 * Настраивает библиотеке Log4j.
 */
public class LoaderLog4jConfig {
    private static ClassLoader loader = LoaderLog4jConfig.class.getClassLoader();

    /**
     * Указывает библиотеке Log4j конфигурационный файл Log4j.xml
     */
    public static void loadConfig() {
        BasicConfigurator.configure();
        URL resource = loader.getResource("Log4j.xml");
        if (resource == null) {
            System.out.println("Не найден Log4j.xml");
            return;
        }
        DOMConfigurator.configure(resource);
    }
}
