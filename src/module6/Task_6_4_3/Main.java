package module6.Task_6_4_3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static List<String> getTextFromSystemIn() {
        final String REGEX = "[^a-zа-я0-9]";
        Scanner scanner = new Scanner(System.in, "UTF-8");
        List<String> result = new ArrayList<>();

        while (scanner.hasNext()) {
            result.addAll(Arrays.asList(
                    scanner.nextLine()
                            .toLowerCase()
                            .replaceAll(REGEX, " ")
                            .split(" ", -1)
            ));
        }
        return result;
    }

    private static Map<String, Long> countAndSortWords(List<String> text) {
        Map<String, Long> result = text.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Map<String, Long> sortedMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
        sortedMap.remove("");
        return sortedMap;
    }

    private static void printFirstTenWords(Map<String, Long> map) {
        final int TEN_WORDS = 10;

        map.keySet().stream()
                .limit(TEN_WORDS)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> text = getTextFromSystemIn();
        Map<String, Long> map = countAndSortWords(text);
        printFirstTenWords(map);
    }
}
