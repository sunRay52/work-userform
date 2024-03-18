/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/work-userform
 *
 * Licensed under the Apache License 2.0
 */

package org.example;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
//задать вопрос, почему только статические методы класса можно передавать?
//когда можно создать объект - Repository

@Getter
public class Repository {

    private final List<User> contacts = new ArrayList<>();

    @SneakyThrows
    public void addUser(final User user) {
        int phase = 0;
        for (User userInList : contacts) {
            if (userInList.getEmail().equals(user.getEmail())) {
                phase += 1;
                System.out.println("Пользователь с таким email уже существует");
                break;
            }
        }
        if (phase == 0) {
            contacts.add(user);
            System.out.println("Пользователь с email: " + user.getEmail() + "в контактах!");
        }
    }

    @SneakyThrows
    public void removeUser(final String email) {
        if (contacts.removeIf(user -> email.equals(user.getEmail()))) {
            System.out.println("Пользователь с email: " + email + " удален");
        } else {
            System.out.println("Пользователь с email: " + email + " не найден");
        }
    }

    public void checkRepository() {
        System.out.println("Список контактов: ");
        final StringBuilder str = new StringBuilder();
        contacts.forEach(user -> str.append(user.getFio() + ';' + user.getNumber() + ';' + user.getEmail() + '\n'));
        System.out.println(str);
    }
}
