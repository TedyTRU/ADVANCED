package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05_Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1.
        String[] robots = scanner.nextLine().split(";");
        String[] names = new String[robots.length];
        int[] processTime = new int[robots.length];
        int[] robotsWorkLeft = new int[robots.length];

        for (int i = 0; i < robots.length; i++) {
            String robot = robots[i];
            String name = robot.split("-")[0];
            names[i] = name;
            int robotTime = Integer.parseInt(robot.split("-")[1]);
            processTime[i] = robotTime;
        }

        // 2.
        String startTime = scanner.nextLine();
        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        // convert time in seconds
        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        // 3.
        String inputProduct;
        ArrayDeque<String> queueOfProducts = new ArrayDeque<>();

        while (!"End".equals(inputProduct = scanner.nextLine())) {
            queueOfProducts.offer(inputProduct);
        }

        // 4.
        while (!queueOfProducts.isEmpty()) {
            startTimeInSeconds++;
            String product = queueOfProducts.poll();
            int index = -1;

            for (int i = 0; i < robotsWorkLeft.length; i++) {
                if (robotsWorkLeft[i] > 0) {
                    robotsWorkLeft[i]--;
                }

                if (robotsWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotsWorkLeft[index] = processTime[index];
                System.out.println(printRobotData(names[index], product, startTimeInSeconds));

            } else {
                queueOfProducts.offer(product);
            }
        }
    }

    private static String printRobotData(String robot, String product, int beginTime) {
        long seconds = beginTime % 60;
        long minutes = (beginTime / 60) % 60;
        long hours = (beginTime / (60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return String.format("%s - %s [%s]", robot, product, time);
    }
}
