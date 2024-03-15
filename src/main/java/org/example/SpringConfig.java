/*
 * Copyright (c) 2019-2024. Luka Pavlov and others.
 * https://github.com/sunRay52/work-userform
 *
 * Licensed under the Apache License 2.0
 */

package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class SpringConfig {
    @Bean
    public Wrapper wrapping(final Repository repository) {
        return new Wrapper(repository);
    }

    @Bean
    public Repository repository() {
        return new Repository();
    }

    @Bean
    public Render render(final Repository repository) {
        return new Render(repository);
    }

    @Bean
    public Read read(final Repository repository) {
        return new Read(repository);
    }
 }


