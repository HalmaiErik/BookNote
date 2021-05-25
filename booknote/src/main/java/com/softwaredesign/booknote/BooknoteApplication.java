package com.softwaredesign.booknote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BooknoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooknoteApplication.class, args);
    }
}
