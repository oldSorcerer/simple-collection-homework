package com.company;

import java.util.*;

import static com.company.ConsoleHelper.*;
import static com.company.Constants.PATTERN;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        List<String> list = new ArrayList<>();
        for (String letter1 : letters) {
            for (int i = 0; i <= 999; i += 111) {
                for (String letter2 : letters) {
                    for (String letter3 : letters) {
                        for (int j = 0; j <= 199; j++) {
                            list.add(String.format("%s%03d%s%s%02d", letter1, i, letter2, letter3, j));
                        }
                    }
                }
            }
        }

        list.sort(Comparator.naturalOrder());
        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long startTime = System.nanoTime();
        boolean isFound = list.contains(number);
        long endTime = System.nanoTime();
        writeMessage(String.format(PATTERN, "перебором", number, (isFound ? "" : " не"), endTime - startTime));
        return isFound;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(sortedList, number);
        boolean isFound = index >= 0;
        long endTime = System.nanoTime();
        writeMessage(String.format(PATTERN, "Бинарный поиск", number, (isFound ? "" : " не"), endTime - startTime));
        return isFound;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long startTime = System.nanoTime();
        boolean isFound = hashSet.contains(number);
        long endTime = System.nanoTime();
        writeMessage(String.format(PATTERN, "в HashSet", number, (isFound ? "" : " не"), endTime - startTime));
        return isFound;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        long startTime = System.nanoTime();
        boolean isFound = treeSet.contains(number);
        long endTime = System.nanoTime();
        writeMessage(String.format(PATTERN, "в TreeSet", number, (isFound ? "" : " не"), endTime - startTime));
        return isFound;
    }
}
