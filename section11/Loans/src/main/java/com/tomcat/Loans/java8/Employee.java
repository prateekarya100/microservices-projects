package com.tomcat.Loans.java8;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;
    private String email;
    private int age;
    private String city;
    private double experience; // in years
}
