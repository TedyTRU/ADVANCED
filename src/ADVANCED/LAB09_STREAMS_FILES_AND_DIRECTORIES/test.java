package ADVANCED.LAB09_STREAMS_FILES_AND_DIRECTORIES;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

//        try {
//            FileInputStream inputStream =
//                    new FileInputStream("C:\\Users\\Teodora\\Desktop\\my-demo.txt");
//
//            Scanner scanner = new Scanner(inputStream);
//            String str = scanner.nextLine();
//            System.out.println(str);
//
//
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }


//        try {
//            FileInputStream inputStream =
//                    new FileInputStream("C:\\Users\\Teodora\\Desktop\\my-demo.txt");
//
//            Scanner scanner = new Scanner(inputStream);
//
//            int oneByte = inputStream.read();
//            while (oneByte >= 0) {
//                System.out.print(((char) oneByte));
//                oneByte = inputStream.read();
//            }
//
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }


        try {

            int number = Integer.parseInt("3-Tree");
            System.out.println(number);

        } catch (NumberFormatException ex) {

            //re throw
            throw new IllegalStateException(ex);

            //System.out.println(ex.getMessage());

        } finally {
            System.out.println("I will always be printed out");
        }



    }
}
