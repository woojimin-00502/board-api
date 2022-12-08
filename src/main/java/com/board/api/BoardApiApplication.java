package com.board.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BoardApiApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(BoardApiApplication.class)
                //.properties()
                .run(args);
    }
}