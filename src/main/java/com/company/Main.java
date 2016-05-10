package com.company;

import com.company.file.FileManager;
import com.company.pars.DataJavaClass;
import com.company.pars.TXTParsingAbstract;
import com.company.pars.TXTParsingJava;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


/**
 * Main class.
 */
 class Main {
    private static final String STRING = "src\\main\\resources\\test";
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LoaderLog4jConfig.loadConfig();
        LOGGER.debug("Args = "+ Arrays.toString(args));


        if (!(args.length == 2 && args[0].equals("scan"))) {
            printError();
            return;
        }

        FileManager fileManager = new FileManager();
        File[] allFile = fileManager.toAllFile(args[1], "java");
        TXTParsingAbstract<DataJavaClass> txtParsingAbstract = new TXTParsingJava();
        String returnTXT = "";
        for (File file : allFile) {
            returnTXT = returnTXT+"\n======================\n"+txtParsingAbstract.pars(file).toString();
        }

        FileWriter fileWriter = null;
        try {
            File fileReport = new File("report.info");
            fileReport.createNewFile();
            fileWriter = new FileWriter(fileReport);
            fileWriter.write(returnTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert fileWriter != null;
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void printError() {
        System.out.println("Not correctly entered arguments!!");
        System.out.println("Example: \"scan С:\\MyFile\" (Path must not contain spaces).");
    }
}
