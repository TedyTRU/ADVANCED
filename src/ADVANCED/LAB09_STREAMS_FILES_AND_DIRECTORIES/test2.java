package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2 {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        System.err.println("out");

        var reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

    }
}
