package Core.module6.Task_6_2_1;


import java.util.*;

public class Main {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> diffSet = new HashSet<>(set1);
        diffSet.addAll(set2);
        diffSet.removeIf(t -> set1.contains(t) && set2.contains(t));
        return diffSet;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3};
        Integer[] integers1 = {0, 1, 2};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(integers));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(integers1));

        Set<Integer> result = symmetricDifference(set1, set2);
        System.out.println(Arrays.toString(result.toArray()));
    }
}