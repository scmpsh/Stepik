package Core.module5.Task_5_3_2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += Double.parseDouble(scanner.next());
            } else {
                scanner.next();
            }
        }
        System.out.printf("%.6f\n", sum);
    }
}
