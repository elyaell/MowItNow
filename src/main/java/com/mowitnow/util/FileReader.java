package com.mowitnow.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private final Logger LOG = LogManager.getLogger(FileReader.class);
    private BufferedReader reader;

    public FileReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Load the file and convert the content into a list of lines
     *
     * @param filename file
     * @return lines of the file
     */
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

    /**
     * Allow the user to choose a file from the list of files
     *
     * @return the chosen file
     */
    public String chooseFile() {
        List<String> files ;
        do {
            files = listingFolderContext();
        } while (files.isEmpty());
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
        String folderPath = chooseDirectory();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(ClassLoader.getSystemResource(folderPath).toURI()))) {
            int cpt = 0;
            LOG.info("Available initializations : ");
            for (Path path : stream) {
                if (!Files.isDirectory(path) && path.getFileName().toString().contains("txt")) {
                    LOG.info("[{}] - {}", cpt, path.getFileName().toString());
                    fileList.add(path.getFileName().toString());
                    cpt++;
                }
            }
        } catch (IOException | URISyntaxException e) {
            LOG.error("Error during folder reading", e);
        }
        return fileList;
    }

    private String chooseDirectory() {
        String path = "";
        System.out.print("Folder with instructions files : ");
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
