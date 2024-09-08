package com.company;

import static com.company.ConsoleHelper.*;
import static com.company.Constants.*;

public class EmailListApp {

    public void init() {
        EmailList emailList = new EmailList();

        while (true) {
            String input = readString();
            if (input.equals(EXIT)) {
                break;
            } else if (input.startsWith(ADD)) {
                String email = input.substring(4);
                emailList.add(email);
            } else if (input.equals(LIST)) {
                emailList.getSortedEmails().forEach(ConsoleHelper::writeMessage);
            } else {
                writeMessage(WRONG_EMAIL_ANSWER);
            }
        }
    }
}