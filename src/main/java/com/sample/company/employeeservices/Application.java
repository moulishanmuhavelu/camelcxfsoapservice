package com.sample.company.employeeservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * The Class Application.
 */
/**
 * @author C50739
 *
 */
@SpringBootApplication
@ImportResource({ "classpath:spring/spring-config.xml" })
public class Application {
    
    /**
     * Bootstrap and launch Spring EmployeeDetail application.
     *
     * @param args - arguments required for launching application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}