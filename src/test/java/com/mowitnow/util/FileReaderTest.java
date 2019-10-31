package com.mowitnow.util;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileReaderTest {

    private FileReader fileReader = new FileReader();

    @Test
    public void testLoadFile() {
        String filename = "mower_1.txt";
        List<String> lines = fileReader.loadFile(filename);
        assertEquals("[5 5, 1 2 N, GAGAGAGAA]", lines.toString());
    }

}