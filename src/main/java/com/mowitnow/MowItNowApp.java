package com.mowitnow;

import com.mowitnow.exception.MowItNowException;
import com.mowitnow.service.MowerLauncher;
import com.mowitnow.util.FileReader;

public class MowItNowApp {

    public static void main(String[] args) throws MowItNowException {
        MowerLauncher mowerLauncher = new MowerLauncher();
        FileReader fileReader = new FileReader();
        String filename = fileReader.chooseFile();
        mowerLauncher.launch(filename);
    }

}
