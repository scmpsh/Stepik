package module6.Task_6_4_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> listOfStream = stream.collect(Collectors.toList());
        minMaxConsumer.accept(
                listOfStream.isEmpty() ? null : listOfStream.stream().min(order).get(),
                listOfStream.isEmpty() ? null : listOfStream.stream().max(order).get()
        );
    }

    public static void main(String[] args) {
        Stream stream = Arrays.stream(new Integer[]{10, 20, 1, 5, 8, 94, 1, -52, 0});
        Comparator<Integer> comparator = Integer::compare;
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> {
            System.out.println(min + " " + max);
        };
        findMinMax(stream, comparator, biConsumer);
    }
}
