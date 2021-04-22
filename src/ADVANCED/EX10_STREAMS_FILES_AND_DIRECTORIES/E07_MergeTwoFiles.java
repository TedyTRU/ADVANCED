package ADVANCED.EX10_STREAMS_FILES_AND_DIRECTORIES;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class E07_MergeTwoFiles {


    private static final String INPUT_ONE = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/inputOne.txt";
    private static final String INPUT_TWO = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/inputTwo.txt";
    private static final String OUTPUT = "src/ADVANCED/EX10_STREAMS_FILES_AND_DIRECTORIES/Resources/output.txt";

    public static void main(String[] args) {

        try (BufferedReader readerOne = new BufferedReader(new FileReader(INPUT_ONE));
             BufferedReader readerTwo = new BufferedReader(new FileReader(INPUT_TWO));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT))) {

            String firstInput = readerOne.readLine();
            String secondInput = readerTwo.readLine();

            while (firstInput != null) {
                writer.println(firstInput);

                firstInput = readerOne.readLine();
            }

            while (secondInput != null) {
                writer.println(secondInput);

                secondInput = readerTwo.readLine();
            }


        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
