package com.tomcat.Loans.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ComparatorSortingJava8 {

     static List<Employee> employeeList = EmployeeDatabase.employeeList();
     static Predicate<Employee> salary_more_than_50000 = (employee -> employee.getSalary() > 50000);

    public static void main(String[] args) {
//        employeeList.forEach(System.out::println);

        // sort salary using sorted double compare
//        employeeList.stream()
//                .sorted((e1, e2) -> Double.compare(e2.getSalary(),e1.getSalary()))
//                .forEach(System.out::println);

//        employeeList.stream()
//                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
//                .map(Employee::getName)
//                .toList().forEach(System.out::println);

        // NAME - SALARY
//        System.out.println(sortNameAndSalary(employeeList).entrySet());

        // Function<String,Double> - name -> salary
    // Function<List<Employee>, Map<String,Double>> - name -> salary
//        Function<List<Employee>,Map<String,Double>> function = ComparatorSortingJava8::sortNameAndSalaryByFunction;
//        System.out.println(function.apply(employeeList));

        //Filter employees who have a salary greater than 50000. [RSystems]
//        employeeList.stream()
//                .filter(salary_more_than_50000)
//                .map(Employee::getName)
//                .toList().forEach(System.out::println);

//        System.out.println(calc_salary_more_than_50000(employeeList));

        //Sort the filtered employees by their names in ascending order.[RSystems]
//        find_sort_filtered_emp_by_names(employeeList);

        // SUM OF SQUARES
//        System.out.println(sum_of_squares(Arrays.asList(1,2,3,4,5)));
        // 1+4+9+16+25 = 55

//        Predicate<Employee> salary_more_than_62000 = (emp->emp.getSalary() < 62000);

//        employeeList.stream()
//                .filter(salary_more_than_62000)
//                .forEach(System.out::println);
    }

//    private static int sum_of_squares(List<Integer> list) {
//        return list.stream()
//                .mapToInt(v-> v * v)
//                .sum();
//    }

//    private static void find_sort_filtered_emp_by_names(List<Employee> employees) {
//         employees.stream()
////                .filter(salary_more_than_50000)
//                 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
//                .map(Employee::getName).forEach(System.out::println);
//    }

//    private static Map<String,Double> calc_salary_more_than_50000(List<Employee> employees) {
//        Map<String,Double> map = new HashMap<>();
//        List<Employee> filtered = employees.stream().filter(salary_more_than_50000).toList();
//        for (Employee employee: filtered){
//            map.put(employee.getName(), employee.getSalary());
//        }
//        return map;
//    }


//    private static Map<String,Double> sortNameAndSalaryByFunction( List<Employee> employeeList) {
//        Map<String,Double> map = new HashMap<>();
//        for(Employee employee:employeeList){
//            map.put(employee.getName().toUpperCase(), employee.getSalary());
//        }
//        return map;
//    }

//    private static Map<String,Double> sortNameAndSalary(List<Employee> employees) {
//        Map<String,Double> map = new HashMap<>();
//        for(Employee employee:employees){
//            map.put(employee.getName().toUpperCase(), employee.getSalary());
//        }
//        return map;
//    }


}
