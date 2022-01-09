package module5.Task_5_3_2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            /*
            * @todo избавиться от try{}catch{}
            */
            try {
                sum += Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {

            }
        }
        System.out.printf("%.6f", sum);
    }
}
