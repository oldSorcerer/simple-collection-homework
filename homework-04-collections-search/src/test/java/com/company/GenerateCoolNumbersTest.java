package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Поиск красивых автомобильных номеров")
public class GenerateCoolNumbersTest {

    public static final String LETTERS = "АВЕКМНОРСТУХ";
    public static final String CAR_NUMBER_REGEX =
            String.format("^[%s]\\d{3}[%s]{2}\\d{2,3}$", LETTERS, LETTERS);

    static List<String> carsNumber;

    @BeforeAll
    static void setUp() {
        carsNumber = CoolNumbers.generateCoolNumbers();
    }

    @Test
    @DisplayName("Список размером больше 2 млн")
    void coolNumbersSizeTest() {
        System.out.println("Размер списка:" + carsNumber.size());
        assertTrue(carsNumber.size() >= 2_000_000,
                "Номеров должно быть больше 2 млн штук");
    }

    @Test
    @DisplayName("Список состоит из номеров российского формата")
    void coolNumbersFormatTest() {
        assertTrue(carsNumber.size() > 0,
                "Список пуст!");

        for (int i = 0; i < 10; i++) {
            assertTrue(getRandomCarNumber().matches(CAR_NUMBER_REGEX));
        }
    }

    private String getRandomCarNumber() {
        return carsNumber.get(new Random().nextInt(carsNumber.size()));
    }
}