package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class L02_test {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("out.txt");
        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte = inputStream.read();

        while (singleByte >= 0) {
            writer.print(Integer.toBinaryString(singleByte) + " ");

            singleByte = inputStream.read();
        }

        writer.close();
        inputStream.close();

    }
}
