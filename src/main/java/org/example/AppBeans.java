package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppBeans {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.getEnvironment().setActiveProfiles();
        ctx.register(SpringConfig.class);
        ctx.refresh();

        System.out.println("Привет, ты запустил контакты!");
        ctx.getBean("addContact","add");
    }
}