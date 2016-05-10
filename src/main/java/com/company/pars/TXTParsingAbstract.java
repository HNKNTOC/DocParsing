package com.company.pars;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * В данном абстрактном классе реализуется общий функционал для TXTParsing.
 * TXTParsingAbstract считывает с файла по одной строке и передаёт в метод readeLine().
 * Обработка строки остается за наследниками данного класса.
 */
public abstract class TXTParsingAbstract<T> implements TXTParsing<T> {

    private static final Logger LOGGER = LogManager.getLogger(TXTParsingAbstract.class);

    /**
     * Считывает строки из файла и передаёт их readeLine().
     * По окончанию считывания вызывает getData() и возвращает полученное.
     * @param file txt файл.
     * @return mapData в котором содержится данные о парсинге.
     */
    @Override
    public T pars(File file) {
        BufferedReader bufferedReader = null;
        LOGGER.info("Pars file"+file.getPath());
        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line!=null){
                    readeLine(line);
                }else {
                    return getData();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Класс реализующий readeLine() получает строку и парсит нужные данные.
     * @param newLine спарсеная строка.
     */
    protected abstract void readeLine(String newLine);

    /**
     * Возвращает спарсенные данные.
     * @return
     */
    protected abstract T getData();
}
