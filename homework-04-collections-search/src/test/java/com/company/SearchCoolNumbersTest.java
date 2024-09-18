package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for homework CoolNumbers app
 */

@DisplayName("Поиск красивых автомобильных номеров")
class SearchCoolNumbersTest {

    public static final String EXISTED_CAR_NUMBER = "О444ЕС30";
    public static final String EXISTED_FIRST_SORTED_CAR_NUMBER = "А111ЕХ40";

    public static final String NOT_CAR_NUMBER = "HH5677U67";

    public static final List<String> NUMBERS = List.of(
            EXISTED_CAR_NUMBER, EXISTED_FIRST_SORTED_CAR_NUMBER,
            "В555УН152", "Р666СР164", "Н666ТТ58", "О666МК04", "Т777ТМ46",
            "А999НХ99", "У000ОН77", "У999НЕ09", "М666СК05", "О448ЕС30",
            "А777ВМ90", "Х222УС06", "А222ХК33", "М444НЕ199", "С888ВК21",
            "Н888ТМ41", "С111ЕХ40", "Т777НО154", "Н777ХМ61", "У888АТ50");

    @Test
    @DisplayName("Поиск перебором - номер есть в списке")
    void bruteForceSearchFound() {
        List<String> list = new ArrayList<>(NUMBERS);
        assertTrue(CoolNumbers.bruteForceSearchInList(list, EXISTED_CAR_NUMBER),
                "Номер есть в списке, но не найден методом прямого перебора");
    }

    @Test
    @DisplayName("Поиск перебором - номера нет в списке")
    void bruteForceSearchNotFound() {
        List<String> list = new ArrayList<>(NUMBERS);
        assertFalse(CoolNumbers.bruteForceSearchInList(list, NOT_CAR_NUMBER),
                "Номера нет в списке, но метод его нашел.");
    }

    @Test
    @DisplayName("Бинарный поиск - номер есть в списке")
    void binarySearchFound() {
        List<String> list = NUMBERS.stream()
                .sorted()
                .collect(Collectors.toList());

        assertTrue(CoolNumbers.binarySearchInList(list, EXISTED_FIRST_SORTED_CAR_NUMBER),
                "Номер есть в списке, но не найден методом бинарного поиска");
    }

    @Test
    @DisplayName("Бинарный поиск - номерa нет в списке")
    void binarySearchNotFound() {
        List<String> list = NUMBERS.stream()
                .sorted()
                .collect(Collectors.toList());

        assertFalse(CoolNumbers.binarySearchInList(list, NOT_CAR_NUMBER),
                "Номера нет в списке, но метод его нашел.");
    }

    @Test
    @DisplayName("Поиск по HashSet - номер есть в списке")
    void hashSetSearchFound() {
        HashSet<String> set = new HashSet<>(NUMBERS);
        assertTrue(CoolNumbers.searchInHashSet(set, EXISTED_CAR_NUMBER),
                "Номер есть в списке, но не найден методом поиска по HashSet");
    }

    @Test
    @DisplayName("Поиск по HashSet - номера нет в списке")
    void hashSetSearchNotFound() {
        HashSet<String> set = new HashSet<>(NUMBERS);
        assertFalse(CoolNumbers.searchInHashSet(set, NOT_CAR_NUMBER),
                "Номера нет в списке, но метод его нашел.");
    }


    @Test
    @DisplayName("Поиск по TreeSet - номер есть в списке")
    void treeSetSearchFound() {
        TreeSet<String> set = new TreeSet<>(NUMBERS);
        assertTrue(CoolNumbers.searchInTreeSet(set, EXISTED_CAR_NUMBER),
                "Номер есть в списке, но не найден методом поиска по TreeSet");
    }

    @Test
    @DisplayName("Поиск по TreeSet - номера нет в списке")
    void treeSetSearchNotFound() {
        TreeSet<String> set = new TreeSet<>(NUMBERS);
        assertFalse(CoolNumbers.searchInTreeSet(set, NOT_CAR_NUMBER),
                "Номера нет в списке, но метод его нашел.");
    }
}