package com.example.taskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication bundles three annotations into one:
// @Configuration, @EnableAutoConfiguration, @ComponentScan.
// In short: this tells Spring "scan this package and everything below it
// for @Component/@Service/@Repository/@RestController classes, wire them
// all together, and auto-configure things like the embedded web server
// and database connection based on what's on the classpath."
@SpringBootApplication
public class TaskApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }
}
