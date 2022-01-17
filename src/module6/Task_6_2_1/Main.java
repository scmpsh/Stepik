package module6.Task_6_2_1;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> matchSet = new HashSet<>(set1);
        Set<T> diffSet = new HashSet<>(set1);
        matchSet.retainAll(set2);
        diffSet.addAll(set2);
        diffSet.removeAll(matchSet);
        return diffSet;
    }

    public static void main(String[] args) {
        Integer[] integers = {1,2,3};
        Integer[] integers1 = {0,1,2};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(integers));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(integers1));

        Set<Integer> result =  symmetricDifference(set1, set2);
        System.out.println(Arrays.toString(result.toArray()));
    }
}