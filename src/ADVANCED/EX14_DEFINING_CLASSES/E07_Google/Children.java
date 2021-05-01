package ADVANCED.EX14_DEFINING_CLASSES.E07_Google;

public class Children {

    private String name;
    private String birthday;

    public Children() {}

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}
