package org.example;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String fio;
    private String number;
    private String email;

    public User(String str) {
        String[] arr = str.split(";");
        fio = arr[0].trim();
        number = arr[1].trim();
        email = arr[2].trim();
    }
    @Override
    public String toString() {
        return fio + ";" + number + ";" + email;
    }

}
