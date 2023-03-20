package com.example.wtwbackesp32;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class WtwBackEsp32Application {

    public static void main(String[] args) {
        SpringApplication.run(WtwBackEsp32Application.class, args);
    }

}
