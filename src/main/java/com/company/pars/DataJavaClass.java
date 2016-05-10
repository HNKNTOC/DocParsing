package com.company.pars;

import java.util.HashMap;

/**
 * Класс хранит информацию о документации файла.
 */
public class DataJavaClass {
    private String className;
    private String classDoc;
    /**
     * mapMethod Key - имя метода Value - документация метода.
     */
    private HashMap<String,String> mapMethod = new HashMap<>();

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassDoc(String classDoc) {
        this.classDoc = classDoc;
    }

    public HashMap<String, String> getMapMethod() {
        return mapMethod;
    }

    @Override
    public String toString() {
        String s = className+":"+classDoc;
        for (String nameMethod : mapMethod.keySet()) {
            s = s+"\n"+nameMethod+":"+mapMethod.get(nameMethod);
        }
        return s;
    }
}
