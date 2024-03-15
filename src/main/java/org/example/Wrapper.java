/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/work-userform
 *
 * Licensed under the Apache License 2.0
 */

package org.example;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor // по файнал
public class Wrapper {
    Scanner scan = new Scanner(System.in);
    private final Repository rep;

    public void wrappering(final String comand) {
            if ("add".equals(comand)) {
                System.out.println("Введите значение / Пример: Андроников Дмитрий Дмитриевич; 899099999; email@gmail.com");
                final String str = scan.nextLine();
                if (mainFilter(str)) {
                    routing(str, "add");
                } else {
                    System.out.println("Введеные вами данные не соответствуют форме");
                }
            } else if ("remove".equals(comand)) {
                System.out.println("Введите значение / Пример: email@gmail.com");
                final String email = scan.nextLine();
                if (emailFilter(email)) {
                    routing(email, "remove");
                } else {
                    System.out.println("Введеные вами данные не соответствуют форме");
                }
            } else {
                rep.checkRepository();
            }
        }

    private void routing(final String str, final String route) {
        if ("add".equals(route)) {
            final String[] array = fromString(str);
            rep.addUser(new User(array[0], array[1], array[2]));
        } else if ("remove".equals(route)) {
            rep.removeUser(str);
        }
    }

    private boolean mainFilter(final String str) { // проверка ФИО / номера телефона / почты / структуры отправки (... ; ... ; ...)
        final String[] arr = str.split(";");
        int count = 0;

        if (arr.length != 3) { // проверка структуры отправки (... ; ... ; ...)
            System.out.println("Вы ошиблись с кол-во полей");
            count++;
        }
        if (arr[0].split(" ").length != 3) { // проверка ФИО
            System.out.println("Вы ошиблись в ФИО");
            count++;
        }
        if (arr[1].length() != 11 || arr[1].length() != 12) { // проверка номера телефона - он должен состоять из 11 - 12 знаков
            try {
                Long.parseLong(arr[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Вы ошиблись в номере");
                count++;
            }
        }
        if (!emailFilter(arr[2])) { // проверка почты
            System.out.println("Вы ошиблись в email");
            count++;
        }
        return count == 0;
    }

    private boolean emailFilter(final String str) { // проверка почты
        return str.trim().matches("^[0-9a-zA-Z]+@[0-9a-z_]+.[0-9a-z_]+$");
    }

    public String[] fromString(final String str) {
        return str.split(";");
    }
}
