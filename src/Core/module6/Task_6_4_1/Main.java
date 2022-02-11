package Core.module6.Task_6_4_1;

import java.util.stream.IntStream;

public class Main {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, f -> (int) ((Math.pow(f, 2)) / 10 % 1000));// your implementation here
    }

    public static void main(String[] args) {
        int seed = 13;
        pseudoRandomStream(seed).limit(15).forEach(x -> System.out.print(x + " "));
    }
}
