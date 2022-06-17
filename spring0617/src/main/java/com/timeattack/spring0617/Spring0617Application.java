package com.timeattack.spring0617;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Spring0617Application {

    public static void main(String[] args) {

        SpringApplication.run(Spring0617Application.class, args);
    }

}
