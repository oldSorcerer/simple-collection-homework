package com.company;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@UtilityClass
public class ConsoleHelper {

    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public String readString() {
        return CONSOLE.readLine();
    }
}
