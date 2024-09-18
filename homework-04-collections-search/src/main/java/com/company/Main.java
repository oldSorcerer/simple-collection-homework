package com.company;

import java.util.*;

import static com.company.ConsoleHelper.*;

public class Main {

    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска вводимого номера в консоль в каждой из структуры данных
     - проанализировать полученные данные
     */

    public static void main(String[] args) {

        writeMessage(Constants.ENTER_INFO);
        String number = readString();

        List<String> strings = CoolNumbers.generateCoolNumbers();

        CoolNumbers.bruteForceSearchInList(strings, number);

        CoolNumbers.binarySearchInList(strings, number);

        CoolNumbers.searchInHashSet(new HashSet<>(strings), number);

        CoolNumbers.searchInTreeSet(new TreeSet<>(strings), number);
    }
}