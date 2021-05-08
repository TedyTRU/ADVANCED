package ADVANCED.EX20_ITERATORS_AND_COMPARATORS.E06_StrategyPattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
        //return Integer.compare(p1.getAge(), p2.getAge());
    }
}
