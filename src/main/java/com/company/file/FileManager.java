package com.company.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Данный класс отвечает за работу с файловой системой.
 */
public class FileManager {
    private static final Logger LOGGER = LogManager.getLogger(FileManager.class);

    /**
     * Возврашает все файлы из заданой деректории.
     *
     * @param path      путь до деректории.
     * @param extension расширение фойлов которых нужно вернуть.
     * @return лист с найдеными файлами.
     */
    public File[] toAllFile(String path, String extension) {
        LOGGER.debug("toAllFile "+path+" extension:"+extension);
        File file = new File(path);
        if (!checkDirectory(file)) return new File[]{};
        return file.listFiles(new FilterExtension(extension));
    }

    /**
     * Проверка создана ли деректория.
     *
     * @param file дериктория которую нужно проверить.
     * @return false если деректория не найдена.
     */
    private boolean checkDirectory(File file) {
        if (!file.isDirectory()) {
            LOGGER.warn("Путь " + file.getAbsolutePath() + " не евляется дерикторией!");
            return false;
        }
        return true;
    }
}
