package ADVANCED.EX18_GENERICS.E11_Threeuple;

public class Threeuple<K, V, S> {
    private K firstEl;
    private V secondEl;
    private S thirdEl;

    public Threeuple(K firstEl, V secondEl, S thirdEl) {
        this.firstEl = firstEl;
        this.secondEl = secondEl;
        this.thirdEl = thirdEl;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s",
                this.firstEl, this.secondEl, this.thirdEl);
    }
}
