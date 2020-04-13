package Java4_13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("c");
        System.out.println(set.contains("a"));
        set.remove("b");
        System.out.println(set.contains("b"));
        Iterator<String> iterable = set.iterator();
        while (iterable.hasNext()){
            String next = iterable.next();
            System.out.println(next);
        }
    }
}
