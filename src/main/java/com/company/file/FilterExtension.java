package com.company.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Фильтр файлов по расширению.
 */
class FilterExtension implements FilenameFilter {
    /**
     * Расширении файла для сортировки.
     */
    private final String extension;

    FilterExtension(String string) {
        this.extension = string;
    }

    /**
     * Проверка есть ли у файла заданное расширение.
     * @param dir Путь до файла.
     * @param name Имя файла.
     * @return false если в имени файла нет заданного расширения.
     */
    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith("."+extension);
    }
}
