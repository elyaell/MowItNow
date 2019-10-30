package com.mowitnow.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FileReaderTest {

    private FileReader fileReader = new FileReader();

    @Test
    public void testLoadFile() {
        String filename = "mower_1.txt";
        List<String> lines = fileReader.loadFile(filename);
        assertEquals("[5 5, 1 2 N, GAGAGAGAA]", lines.toString());
    }

}