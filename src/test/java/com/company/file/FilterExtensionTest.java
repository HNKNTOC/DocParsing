package com.company.file;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Тесты FilterExtension.
 */
public class FilterExtensionTest {
    private FilterExtension filterTXT;
    private FilterExtension filterJar;
    @Before
    public void setUp() throws Exception {
        filterTXT = new FilterExtension("txt");
        filterJar = new FilterExtension("jar");
    }

    @Test
    public void accept() throws Exception {
        File dir = new File("");
        assertTrue(filterJar.accept(dir,"test.jar"));
        assertTrue(filterJar.accept(dir,"test2.jar"));
        assertTrue(filterJar.accept(dir,"jar.test.jar"));


        assertFalse(filterJar.accept(dir,"test.txt"));
        assertFalse(filterJar.accept(dir,"HelloWorld.txt"));
        assertFalse(filterJar.accept(dir,"Zip.rar"));

        assertTrue(filterTXT.accept(dir,"jar.test.txt"));
        assertTrue(filterTXT.accept(dir,"test.txt"));
        assertTrue(filterTXT.accept(dir,"HelloWord.txt"));

        assertFalse(filterTXT.accept(dir,"jar.test.jar"));
        assertFalse(filterTXT.accept(dir,"test.rar"));
        assertFalse(filterTXT.accept(dir,"Name.File.zkd"));
    }

}