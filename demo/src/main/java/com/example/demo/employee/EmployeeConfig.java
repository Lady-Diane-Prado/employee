package com.example.demo.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository repository) {
        return args -> {
            Employee johndoe = new Employee(
                    1L,
                    "John Doe",
                    "Jr.",
                    "john.doe@email.com",
                    LocalDate.of(2000, Month.JANUARY,1),
                    "Single",
                    "Filipino"
            );

            Employee janedoe = new Employee(
                    2L,
                    "Jane Doe",
                    "N/A",
                    "jane.doe@email.com",
                    LocalDate.of(2000, Month.FEBRUARY,9),
                    "Single",
                    "Filipino"
            );

            Employee markrobinsons = new Employee(
                    3L,
                    "Mark Robinsons",
                    "N/A",
                    "markrobinsons@email.com",
                    LocalDate.of(1988, Month.NOVEMBER,21),
                    "Married",
                    "Filipino"
            );

            Employee dashrobert = new Employee(
                    4L,
                    "Dash Robert",
                    "IV",
                    "dashroberts@email.com",
                    LocalDate.of(2001, Month.MAY,1),
                    "Single",
                    "Filipino"
            );

            repository.saveAll(
                    List.of(johndoe, janedoe, markrobinsons, dashrobert)
            );

        };
    }
}
