/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/work-userform
 *
 * Licensed under the Apache License 2.0
 */

package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class User {
    private final String fio;
    private final String number;
    private final String email;
}
