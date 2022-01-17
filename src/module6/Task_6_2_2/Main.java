package module6.Task_6_2_2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    static ArrayDeque<Integer> createEvenIndexArray() {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (scanner.hasNext()) {
            if (i % 2 != 0) {
                result.add(scanner.nextInt());
            } else {
                scanner.next();
            }
            i++;
        }
        return result;
    }

    static void printArray(ArrayDeque<Integer> arrayDeque) {
        while (!arrayDeque.isEmpty()) {
            System.out.print(arrayDeque.removeLast() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(createEvenIndexArray());
    }
}
