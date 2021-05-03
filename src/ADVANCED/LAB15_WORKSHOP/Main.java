package ADVANCED.LAB15_WORKSHOP;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        SmartStack stack = new SmartStack();
        stack.push(13);
        stack.push(42);
        stack.push(69);


        //SmartArray smartArray = new SmartArray();

//        smartArray.add(13);
//        smartArray.add(42);

//        int removedValue = smartArray.remove(0);
//        System.out.println(removedValue);

//        int removedValue = smartArray.remove(1);
//        System.out.println(removedValue);
//        System.out.println(smartArray.remove(0));

//        smartArray.add(1);
//
//        for (int i = 1; i < 100; i++) {
//            smartArray.add(0, i + 1);
//        }
//        smartArray.forEach(System.out::println);
//        boolean isTrue = true;
//        while (isTrue) {
//            smartArray.add(13);
//            smartArray.remove(smartArray.size() - 1);
//        }


//        while (!smartArray.isEmpty()) {
//            System.out.println(smartArray.remove(0));
//        }


//        for (int i = 0; i <= smartArray.size(); i++) {
//            System.out.println(smartArray.get(i));
//        }


//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }

        stack.forEach(System.out::println);
        //System.out.println(stack.peek());
        System.out.println();
    }
}
