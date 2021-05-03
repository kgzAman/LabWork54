package com.aman.labwok53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Labwok53Application {

    public static void main(String[] args) {
        SpringApplication.run(Labwok53Application.class, args);
    }

}
