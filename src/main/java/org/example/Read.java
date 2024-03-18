/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/work-userform
 *
 * Licensed under the Apache License 2.0
 */

package org.example;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

@RequiredArgsConstructor
public class Read {

    private final Repository rep;

    @SneakyThrows
    public void reading() {
        final ArrayList<String> contacts = splitLines(new FileReader("src/main/resources/contacts.txt"));
        if (!contacts.get(0).trim().isEmpty()) {
            contacts.forEach(contact -> {
                final String[] userFields = contact.split(";");
                rep.addUser(new User(userFields[0], userFields[1], userFields[2]));
            });
        }
    }

    @SneakyThrows
    private ArrayList<String> splitLines(final FileReader reader) {
        final ArrayList<String> contacts = new ArrayList<>();

        final BufferedReader br = new BufferedReader(reader);

        String line;

        while ((line = br.readLine()) != null) {
            contacts.add(line);
        }
        return contacts;
    }
}

