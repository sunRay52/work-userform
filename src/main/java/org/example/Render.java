/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/work-userform
 *
 * Licensed under the Apache License 2.0
 */

package org.example;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.FileWriter;

@RequiredArgsConstructor
public class Render {
    private final Repository rep;

    @SneakyThrows
    public void rendering() {
        final StringBuilder str = new StringBuilder();
        rep.getContacts().forEach(user -> str.append(userRender(user)));
        try (FileWriter writer = new FileWriter("src/main/resources/contacts.txt", false)) {
            writer.write(str.toString());
        }
    }

    private String userRender(final User user) {
        return user.getFio() + ';' + user.getNumber() + ';' + user.getEmail() + '\n';
    }
}
