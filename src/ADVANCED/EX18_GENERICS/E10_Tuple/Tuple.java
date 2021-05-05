package ADVANCED.EX18_GENERICS.E10_Tuple;

public class Tuple<K, V> {
    private K firstEl;
    private V secondEl;

    public Tuple(K firstEl, V secondEl) {
        this.firstEl = firstEl;
        this.secondEl = secondEl;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.firstEl, this.secondEl);
    }
}
