package com.akushwah.dsalgo.arraylists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Aakash", "Kushwah", 123));
        employeeList.add(new Employee("Mary","Smith", 223));
        employeeList.forEach(emp -> System.out.println(emp));
        Object[] emps = employeeList.toArray();
        Employee[] emps2 = employeeList.toArray(new Employee[employeeList.size()]);
        System.out.println(employeeList.indexOf(new Employee("Aakash","Kushwah", 123)));
    }
}
