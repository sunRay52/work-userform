package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Render {
    public static FileWriter writer;
    public static void rendering() throws IOException {
        StringBuilder str = new StringBuilder();
        Repository.getContacts().forEach(user -> str.append(user.toString() + '\n'));
        writer = new FileWriter("src/main/resources/contacts.txt", false);
        writer.write(str.toString());
        writer.close();
    }
}
