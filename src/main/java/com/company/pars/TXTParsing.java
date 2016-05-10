package com.company.pars;

import java.io.File;

/**
 *  Интерфейс для парсера txt файлов.
 */
public interface TXTParsing<T> {
    /**
     * Парит из txt всю нужную информацию и возвращает её.
     * @param file txt файл.
     * @return данные получинные при парсинге.
     */
    T pars(File file);
}
