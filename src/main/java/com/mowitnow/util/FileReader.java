package com.mowitnow.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    final static Logger LOG = Logger.getLogger(FileReader.class);

    public List<String> loadFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            LOG.error("Error during file reading", e);
        } catch (URISyntaxException e) {
            LOG.error("File not found", e);
        }
        return lines;
    }

}
