package org.example;



import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Scanner;

//задать вопрос, почему только статические методы класса можно передавать?
//когда можно создать объект - Repository

public class Repository  {
    @Getter
    private static final ArrayList<User> contacts = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    @SneakyThrows
    public static void addUser(User user) {
        int phase = 0;
        for (User user_inList : contacts) {
            if (user_inList.getEmail().equals(user.getEmail())) {
                phase += 1;
                System.out.println("Пользователь с таким email уже существует");
                break;
            }
        }
        if (phase == 0) {
            contacts.add(user);
            System.out.println("Пользователь с email: " + user.getEmail() + " добавлен!");
            Render.rendering();
        }
        repeater();

    }
    public static void repeater() {
        System.out.println("Что вы хотите сделать ?");
        System.out.println("Добавить контакт - 1 / Удалить контакт - 2 / Закрыть приложение - любое другое значение");
        int comand = scan.nextInt();
        if (comand == 1) {
            new Wrapper("add");
        } else if (comand == 2) {
            new Wrapper("remove");
        }
    }

    @SneakyThrows
    public static void removeUser(String email) {
        ArrayList<User> copy = contacts;

        contacts.forEach(user -> {
            if (user.getEmail().equals(email)) {
                System.out.println("найден");
                contacts.remove(user);
                System.out.println("удален");
            }
        });
        if (copy.containsAll(contacts)) {
            System.out.println("Пользователь с email: " + email + " не найден");
        } else {
            System.out.println("Пользователь с email: " + email + " удален");
            Render.rendering();
        }
        repeater();
    }
}
