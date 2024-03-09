package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@ComponentScan
@Configuration
public class SpringConfig {
    //@Bean(name = "addContact", destroyMethod = "repeater")
    @Bean(name = "addContact")
    @Lazy
    public Wrapper wrapping(String comand){
        return new Wrapper(comand);
    }
}


