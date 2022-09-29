package org.example;

import java.util.List;
import java.util.stream.Stream;

public class TaskResolverTest {
    private static final String DIVIDER = "#".repeat(30);

    public static void main(String[] args) {
        var names = List.of("Mohamed", "Youssef", "Ahmed", "Mahmoud", "Mustafa", "Yassin", "Taha", "Khaled", "Hamza", "Bilal", "Ibrahim", "Hassan", "Hussein", "Karim", "Tareq", "Abdel-Rahman", "Ali", "Omar", "Halim", "Murad", "Selim", "Abdallah", "Shaimaa", "Fatma", "Maha", "Reem", "Farida", "Aya", "Shahd", "Ashraqat", "Sahar", "Fatin", "Dalal", "Doha", "Fajr", "Suha", "Rowan", "Hosniya", "Hasnaa", "Hosna", "Gamila", "Gamalat", "Habiba");

        printHeader("Task 1");
        System.out.println(TaskResolver.getOddNames(names));

        printHeader("Task 2");
        System.out.println(TaskResolver.getInUppercaseDescending(names));

        printHeader("Task 3");
        System.out.println(TaskResolver.parseAndOrderIntegers(new String[]{"1, 2, 0", "4, 5"}));
        System.out.println(TaskResolver.parseAndOrderIntegers(new String[]{"1, 2, 0, 1, 2, 0", "75", "4, 5"}));
        System.out.println(TaskResolver.parseAndOrderIntegers(new String[]{}));

        printHeader("Task 4");
        System.out.println(TaskResolver.generateRandomLongs(25214903917L, 11, (long) Math.pow(2, 48), 0).limit(15).toList());

        printHeader("Task 5");
        System.out.println(TaskResolver.zip(Stream.of(1, 2, 3, 4, 5), Stream.of(6, 7, 8, 9, 10, 11, 12, 13)).toList());
        System.out.println(TaskResolver.zip(Stream.of("a", "b", "c", "d", "e"), Stream.of("e", "f", "g", "h", "i", "j", "k", "l")).toList());
        System.out.println(TaskResolver.zip(Stream.of("a", "b", "c"), Stream.of()).toList());

        printHeader("Task 5 alt");
        System.out.println(TaskResolver.zipAlt(Stream.of(1, 2, 3, 4, 5), Stream.of(6, 7, 8, 9, 10, 11, 12, 13)).toList());

    }

    private static void printHeader(String name) {
        System.out.println();
        System.out.println(DIVIDER);
        System.out.printf("# %-26s #%n", name);
        System.out.println(DIVIDER);
    }
}