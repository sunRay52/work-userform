package org.example;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
@Profile("default")
public class Wrapper {
    Scanner scan = new Scanner(System.in);

    public Wrapper(String comand) {
        if (comand.equals("add")) {
            System.out.println("Введите значение / Пример: Андроников Дмитрий Дмитриевич; 899099999; email@gmail.com");
            String str = scan.nextLine();
            if (mainFilter(str)) {
                routing(str, "add");
            } else {
                System.out.println("Введеные вами данные со соответствуют форме");
                Repository.repeater();
            }
        } else {
            System.out.println("Введите значение / Пример: email@gmail.com");
            String email = scan.nextLine();
            if (emailFilter(email)) {
                routing(email, "remove");
            } else {
                System.out.println("Введеные вами данные со соответствуют форме");
                Repository.repeater();
            }
        }
    }
    public Wrapper(){}



    private void routing(String str, String route) {
        if (route.equals("add")) {
            Repository.addUser(new User(str));
        } else {
            Repository.removeUser(str);
        }
    }
    private boolean mainFilter(String str) { // проверка ФИО / номера телефона / почты / структуры отправки (... ; ... ; ...)
        String[] arr = str.split(";");
        if (arr.length != 3) { // проверка структуры отправки (... ; ... ; ...)
            System.out.println("Вы ошиблись с кол-во полей");
            return false;
        }
        if (arr[0].split(" ").length != 3) { // проверка ФИО
            System.out.println("Вы ошиблись в ФИО");
            return false;
        }
        if (arr[1].length() != 11 || arr[1].length() != 12) { // проверка номера телефона - он должен состоять из 11 - 12 знаков
            try {
                Long.parseLong(arr[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Вы ошиблись в номере");
                return false;
            }
        }
        if (!emailFilter(arr[2])) { // проверка почты
            System.out.println("Вы ошиблись в email");
            return false;
        }
        return true;
    }
    private boolean emailFilter(String str) { // проверка почты
        return str.trim().matches("^[0-9a-zA-Z]+@[0-9a-z_]+.[0-9a-z_]+$");
    }



}

