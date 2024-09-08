package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static com.company.ConsoleHelper.*;
import static com.company.Constants.WRONG_EMAIL_ANSWER;

public class EmailList {

    private final TreeSet<String> emails;

    public EmailList() {
        emails = new TreeSet<>();
    }

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // TODO принять решение добавлять аргумент email или нет должен этот метод
        if (isValidEmail(email)) {
            emails.add(email.toLowerCase());
        } else {
            writeMessage(WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        return new ArrayList<>(emails);
    }

    public boolean isValidEmail(String email) {
        String REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(REGEX);
    }
}