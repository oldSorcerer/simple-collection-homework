package com.company;

import java.util.Set;

import static com.company.ConsoleHelper.*;
import static com.company.Constants.*;

public class PhoneBookApp {

    public void init() {

        PhoneBook phoneBook = new PhoneBook();

        boolean isExit = false;

        while (!isExit) {
            writeMessage(ENTER_INFO);
            String input = readString();
            if (LIST.equals(input)) {
                Set<String> allContacts = phoneBook.getAllContacts();
                allContacts.forEach(ConsoleHelper::writeMessage);
            } else if (phoneBook.isValidName(input)) {
                if (phoneBook.getNotebook().containsKey(input)) {
                    phoneBook.getContactByName(input).forEach(ConsoleHelper::writeMessage);
                } else {
                    writeMessage(NO_SUCH_NAME);
                    writeMessage(String.format(ENTER_THE_NUMBER_FOR_CONTACT, input));
                    String phone = readString();
                    boolean isValidPhone = phoneBook.isValidPhone(phone);
                    if (isValidPhone) {
                        phoneBook.addContact(input, phone);
                    }
                    printMessage(isValidPhone);
                }
            } else if (phoneBook.isValidPhone(input)) {
                writeMessage(String.format(ENTER_NAME_FOR_NUMBER, input));
                String name = readString();
                boolean isValidName = phoneBook.isValidName(name);
                if (isValidName) {
                    phoneBook.addContact(name, input);
                }
                printMessage(isValidName);
            } else {
                writeMessage(INCORRECT_FORMAT);
                isExit = true;
            }
        }
    }

    private void printMessage(boolean validPhone) {
        writeMessage(validPhone ? CONTACT_SAVED : INCORRECT_FORMAT);
    }
}
