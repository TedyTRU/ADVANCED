package ADVANCED.LAB17_GENERICS.L01_JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> jar = new Jar<>();

        Jar<String> jarString = new Jar<>();

        jar.add(35);
        jar.add(28);
        jar.add(26);

        int removed = jar.remove();

        System.out.println(removed);

    }
}
