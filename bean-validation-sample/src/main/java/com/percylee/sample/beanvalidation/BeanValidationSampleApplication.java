package com.percylee.sample.beanvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = "classpath:ValidationMessages.properties", encoding = "UTF-8")
public class BeanValidationSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanValidationSampleApplication.class, args);
    }

}
