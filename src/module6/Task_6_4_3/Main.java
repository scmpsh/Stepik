package module6.Task_6_4_3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static List<String> getTextFromSystemIn() {
//        final String REGEX = "\\b+[^\\wа-я]+\\b";
        final String REGEX = "[^\\wа-я]";
        Scanner scanner = new Scanner(System.in, "UTF-8");
        List<String> result = new ArrayList<>();
        while (scanner.hasNext()) {
            result.addAll(Arrays.stream(scanner.nextLine().toLowerCase().split(REGEX))
                    .filter(String::isBlank).toList());
        }
        return result;
    }

    private static void countAndSortWords(List<String> text) {
        text.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);
    }

    private static void printFirstTenWords(Map<String, Long> map) {
        final int TEN_WORDS = 10;

        map.keySet().stream()
                .limit(TEN_WORDS)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> text = getTextFromSystemIn();
        countAndSortWords(text);
//        printFirstTenWords(map);
    }
}
