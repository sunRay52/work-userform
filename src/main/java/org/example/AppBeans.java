/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/work-userform
 *
 * Licensed under the Apache License 2.0
 */

package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class AppBeans {
    public static void main(final String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {

            final Wrapper wrap = ctx.getBean(Wrapper.class);
            final Render render = ctx.getBean(Render.class);
            final Read read = ctx.getBean(Read.class);

            read.reading();

            System.out.println("Привет, вы запустили контакты!");

            change(wrap, render);
        }
    }

    public static void change(final Wrapper bean, final Render render) {
        System.out.println("Что вы хотите сделать ?");
        System.out.println("Добавить контакт - 1 / Удалить контакт - 2 / Посмотреть список контактов - 3 / Закрыть приложение - любое другое значение");
        final Scanner scan = new Scanner(System.in);
        final String comand = scan.nextLine();
        if ("1".equals(comand)) {
            bean.wrappering("add");
            render.rendering();
            change(bean, render);
        } else if ("2".equals(comand)) {
            bean.wrappering("remove");
            render.rendering();
            change(bean, render);
        } else if ("3".equals(comand)) {
            bean.wrappering("checkList");
            change(bean, render);
        } else {
            bean.wrappering("exit");
        }
    }
}
