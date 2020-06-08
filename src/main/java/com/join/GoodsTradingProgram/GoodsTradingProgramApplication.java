package com.join.GoodsTradingProgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.join.GoodsTradingProgram.mapper", "com.join.GoodsTradingProgram.controller", "com.join.GoodsTradingProgram.service", "com.join.GoodsTradingProgram.entity"})
public class GoodsTradingProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsTradingProgramApplication.class, args);
    }

}
