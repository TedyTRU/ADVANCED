package ADVANCED.LAB03_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String command = scanner.nextLine();

        while (!command.equals("print")) {

            if (command.equals("cancel")) {
                String fileName = printerQueue.poll();

                if (fileName != null) {
                    System.out.println("Canceled " + fileName);
                } else {
                    System.out.println("Printer is on standby");
                }

            } else {
                printerQueue.offer(command);

            }

            command = scanner.nextLine();
        }

        for (String fileName : printerQueue) {
            System.out.println(fileName);
        }

//        while (!printerQueue.isEmpty()) {
//            System.out.println(printerQueue.poll());
//        }

    }
}
