package com.company.file;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Arrays;

/**
 * Данный класс отвечает за работу с файловой системой.
 */
public class FileManager {
    private static final Logger LOGGER = LogManager.getLogger(FileManager.class);

    /**
     * Возвращает все файлы из заданной директории.
     *
     * @param path      путь до директории.
     * @param extension расширение файлов которых нужно вернуть.
     * @return лист с найденными файлами.
     */
    public File[] toAllFile(String path, String extension) {
        LOGGER.debug("toAllFile "+path+" extension:"+extension);
        File file = new File(path);
        File[] files = new File[]{};
        if (checkDirectory(file)){
            files = file.listFiles(new FilterExtension(extension));
        }
        LOGGER.debug("toAllFile return "+ Arrays.toString(files));
        return files;
    }

    /**
     * Проверка создана ли директория.
     *
     * @param file директория которую нужно проверить.
     * @return false если директория не найдена.
     */
    private boolean checkDirectory(File file) {
        if (!file.isDirectory()) {
            LOGGER.warn("Path " + file.getAbsolutePath() + " is not an existing directory!");
            return false;
        }
        return true;
    }
}
