package com.mowitnow.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    final static Logger LOG = Logger.getLogger(FileReader.class);

    public void loadFile() {
        String filename = "C:\\Users\\Olivia\\Documents\\MowItNow\\src\\main\\resources\\mower_1.txt";
        List<String> lines;
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            lines = stream.collect(Collectors.toList());
            System.out.println(lines);
        } catch (IOException e) {
            LOG.error("Error during file reading", e);
        }
    }

}
