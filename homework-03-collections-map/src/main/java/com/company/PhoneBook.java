package com.company;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class PhoneBook {

    private Map<String, Set<String>> notebook;
    private final String REGEX_PHONE = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    public PhoneBook() {
        notebook = new TreeMap<>();
    }

    public void addContact(String name, String phone) {
        // TODO проверь корректность формата имени и телефона
        // TODO (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // TODO если такой номер уже есть в списке, то перезаписать имя абонента
        if (isValidName(name) && isValidPhone(phone)) {
            notebook = notebook.entrySet().stream()
                    .peek(entry -> entry.getValue().remove(phone))
                    .filter(entry -> !entry.getValue().isEmpty())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

//            for (Map.Entry<String, Set<String>> entry : new HashSet<>(notebook.entrySet())) {
//                entry.getValue().remove(phone);
//                if (entry.getValue().isEmpty()) {
//                    notebook.remove(entry.getKey());
//                }
//            }
            notebook.putIfAbsent(name, new HashSet<>());
            notebook.get(name).add(phone);

        }
    }
    /* new name new phone
     * new name old phone
     * old name new phone
     * old name old phone
     */


    public boolean isValidName(String name) {
        return name.matches("^[a-zA-Zа-яА-ЯёЁ]+$");
    }

    public boolean isValidPhone(String phone) {
        return phone.matches("^\\d{11}$");
    }

    public Set<String> getContactByName(String name) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найден - вернуть пустой TreeSet
        if (!notebook.containsKey(name)) {
            return new TreeSet<>();
        }

        return Set.of(name + " - " + String.join(", ", notebook.get(name)));
    }

    public String getContactByPhone(String phone) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найдены - вернуть пустую строку
        return notebook.entrySet().stream()
                .filter(entry -> entry.getValue().contains(phone))
                .findFirst()
                .map(entry -> entry.getKey() + " - " + String.join(", ", entry.getValue()))
                .orElse("");
    }
//    public String getContactByPhone1(String phone) {
//        for (Map.Entry<String, Set<String>> entry : nameToPhone.entrySet()) {
//            if (entry.getValue().contains(phone)) {
//                return entry.getKey() + " - " + String.join(", ", entry.getValue());
//            }
//        }
//        return "";
//    }


    public Set<String> getAllContacts() {

        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контактов нет в телефонной книге - вернуть пустой TreeSet

        if (notebook.isEmpty()) {
            return new TreeSet<>();
        }

        return notebook.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + String.join(", ", entry.getValue()))
                .collect(Collectors.toSet());

    }
//    public Set<String> getAllContacts1() {
//        Set<String> contacts = new HashSet<>();
//        if (!nameToPhone.isEmpty()) {
//            for (Map.Entry<String, Set<String>> entry : nameToPhone.entrySet()) {
//                String name = entry.getKey();
//                Set<String> setPhones = entry.getValue();
//                String phones = String.join(", ", setPhones);
//                String contact = name + " - " + phones;
//                contacts.add(contact);
//            }
//        }
//        return contacts;
//    }
}