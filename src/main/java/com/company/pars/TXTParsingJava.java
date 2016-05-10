package com.company.pars;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by Nikita on 10.05.2016.
 */
public class TXTParsingJava extends TXTParsingAbstract<DataJavaClass> {
    private static final Logger LOGGER = LogManager.getLogger(TXTParsingJava.class);
    private String thisDoc = "";
    private String oldDoc = "";
    private boolean isDoc;
    private int countDoc;
    private DataJavaClass dataJavaClass = new DataJavaClass();

    @Override
    protected void readeLine(String newLine) {
        LOGGER.debug("newLine:" + newLine);
        if (newLine.contains("*/")) {
            isDoc = false;
            LOGGER.debug("isDoc = false;");
            if(countDoc==1){
                dataJavaClass.setClassDoc(thisDoc);
            }
            oldDoc = thisDoc;
            thisDoc = "";
            return;
        }
        if(newLine.contains("class")){
            String[] split = newLine.split(" ");
            String className = split[2];
            dataJavaClass.setClassName(className);
            LOGGER.debug("className: "+className);
        }
        if (isDoc) {
            thisDoc = thisDoc + newLine + "\n";
            thisDoc = thisDoc.replace("\n","");
            thisDoc = thisDoc.replace("*","");
            return;
        }
        if (newLine.contains("void")) {
            String split = newLine.split(" ")[6];
            dataJavaClass.getMapMethod().put(split.substring(0, split.length()-3),oldDoc);
        }
        if (newLine.contains("/**")) {
            countDoc++;
            isDoc = true;
            LOGGER.debug("isDoc = true;");
            return;
        }
    }

    @Override
    protected DataJavaClass getData() {
        return dataJavaClass;
    }
}
