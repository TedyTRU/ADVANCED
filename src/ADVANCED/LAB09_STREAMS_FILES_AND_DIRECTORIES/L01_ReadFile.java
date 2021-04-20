package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class L01_ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int singleByte = inputStream.read();

        while (singleByte >= 0) {

            System.out.printf("%s ", Integer.toBinaryString(singleByte));

            singleByte = inputStream.read();
        }

        inputStream.close();
    }
}
