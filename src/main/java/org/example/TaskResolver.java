package org.example;

import java.util.*;
import java.util.stream.Stream;

public class TaskResolver {

    private TaskResolver() {
    }

    //Task 1
    public static String getOddNames(List<String> names) {
        int counter = 0;
        StringJoiner sj = new StringJoiner(", ");
        for (String name : names) {
            counter++;
            if (counter % 2 == 1) sj.add(counter + ". " + name);
        }
        return sj.toString();
    }

    //Task 2
    public static List<String> getInUppercaseDescending(List<String> strings) {
        return strings.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).toList();
    }

    //Task 3
    public static String parseAndOrderIntegers(String[] strings) {
        return Arrays.stream(strings)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .mapToInt(Integer::valueOf)
                .sorted()
                .collect(() -> new StringJoiner(", "), (sj, value) -> sj.add(String.valueOf(value)), (sj1, sj2) -> sj1.add(sj2.toString()))
                .toString();
    }

    //Task 4
    public static Stream<Long> generateRandomLongs(long a, long c, long m, long seed) {
        return Stream.iterate(seed, n -> (n * a + c) % m);
    }

    //Task 5
    @SuppressWarnings("unchecked")
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Object[] firstArr = first.toArray();
        Object[] secondArr = second.toArray();
        Object[] result = new Object[Math.min(firstArr.length, secondArr.length) * 2];
        int counter = 0;
        for (int i = 0, length = result.length / 2; i < length; i++) {
            result[counter++] = firstArr[i];
            result[counter++] = secondArr[i];
        }

        return (Stream<T>) Arrays.stream(result);
    }

    //Task 5 (alternative, !all! elements from both streams, mixed semi-randomly)
    private static final Random rand = new Random();

    public static <T> Stream<T> zipAlt(Stream<T> first, Stream<T> second) {

        return Stream.concat(first, second).sorted((o1, o2) -> rand.nextInt(-1, 2));
    }
}
