package com.mowitnow.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FileReader {
    private final Logger LOG = LogManager.getLogger(FileReader.class);

    public FileReader() {
    }

    /**
     * Load the file and convert the content into a list of lines
     *
     * @param filename file
     * @return lines of the file
     */
    public List<String> loadFile(String filename) {
        InputStream input = getClass().getResourceAsStream("/" + filename);
        final InputStreamReader isr = new InputStreamReader(input, StandardCharsets.UTF_8);
        final BufferedReader br = new BufferedReader(isr) ;
        return br.lines().collect(Collectors.toList());
    }

    /**
     * Allow the user to choose a file from the list of files
     *
     * @return the chosen file
     */
    public String chooseFile() {
        List<String> files = listingFolderContext();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice ;
        do {
            System.out.print("File to process : ");
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                choice = -1;
            }
        } while (choice < 0 || choice >= files.size());
        return files.get(choice);
    }

    /**
     * List all available files for configuring the mower
     *
     * @return the list of the files
     */
    private List<String> listingFolderContext() {
        List<String> fileList = new ArrayList<>();
        InputStream input = getClass().getResourceAsStream("/");
        final InputStreamReader isr = new InputStreamReader(input, StandardCharsets.UTF_8);
        final BufferedReader br = new BufferedReader(isr) ;

        LOG.info("Available initializations : ");
        AtomicInteger cpt = new AtomicInteger();
        br.lines().filter(item -> item.contains("txt")).forEach(item -> {
            LOG.info("[{}] - {}", cpt, item);
            fileList.add(item);
            cpt.getAndIncrement();
        });

        return fileList;
    }
}
