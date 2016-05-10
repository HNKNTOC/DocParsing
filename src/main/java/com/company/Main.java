package com.company;

import com.company.file.FileManager;

import java.io.File;


/**
 * Created by Nikita on 09.05.2016.
 */
public class Main {
    private static final String STRING = "src\\main\\resources\\test";
    public static void main(String[] args) {

        args = new String[2];

        args[0] = "scan";
        args[1] = STRING;


        if (!(args.length == 2 && args[0].equals("scan"))) {
            printError();
            return;
        }

        LoaderLog4jConfig.loadConfig();

        FileManager fileManager = new FileManager();
        File[] allFile = fileManager.toAllFile(args[1], "java");
        for (File file : allFile) {
            System.out.println(file.getName());
        }
    }

    private static void printError() {
        System.out.println("Не верно введены аргументы!!");
        System.out.println("Пример:scan путь до директории с java файлами.");
    }
}
