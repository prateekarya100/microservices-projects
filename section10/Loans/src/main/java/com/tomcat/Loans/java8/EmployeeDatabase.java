package com.tomcat.Loans.java8;

import java.util.Arrays;
import java.util.List;

public class EmployeeDatabase {
    public static List<Employee> employeeList() {
      return Arrays.asList(
                new Employee(1, "Prateek", 50000, "IT", "prateek@gmail.com", 26, "Noida", 2.5),
                new Employee(2, "Amit", 60000, "HR", "amit@gmail.com", 30, "Delhi", 5),
                new Employee(3, "Neha", 55000, "Finance", "neha@gmail.com", 28, "Gurgaon", 4),
                new Employee(4, "Rahul", 65000, "IT", "rahul@gmail.com", 27, "Noida", 3),
                new Employee(5, "Anjali", 48000, "Support", "anjali@gmail.com", 25, "Lucknow", 2),
                new Employee(6, "Vikas", 70000, "IT", "vikas@gmail.com", 32, "Delhi", 7),
                new Employee(7, "Pooja", 52000, "HR", "pooja@gmail.com", 29, "Noida", 4),
                new Employee(8, "Rohit", 62000, "Finance", "rohit@gmail.com", 31, "Gurgaon", 6)
        );
    }

    public static void displayAll () {
        employeeList().forEach(System.out::println);
    }
}
