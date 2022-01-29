package module6.Task_6_4_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Stream.Builder<T> copyOfStream = Stream.builder();
        minMaxConsumer.accept(
                stream.peek(copyOfStream).min(order).orElse(null),
                copyOfStream.build().max(order).orElse(null)
        );
    }

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{10, 20, 1, 5, 8, 94, 1, -52, 0});
        Comparator<Integer> comparator = Integer::compare;
        BiConsumer<Integer, Integer> biConsumer = (min, max) -> {
            System.out.println(min + " " + max);
        };
        findMinMax(stream, comparator, biConsumer);
    }
}
