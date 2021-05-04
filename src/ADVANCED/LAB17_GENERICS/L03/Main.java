package ADVANCED.LAB17_GENERICS.L03;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("A", "B");

        System.out.println("B".compareTo("A"));

        System.out.println(stringScale.getHeavier());

    }
}
