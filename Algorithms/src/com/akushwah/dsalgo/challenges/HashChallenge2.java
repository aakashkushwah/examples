package com.akushwah.dsalgo.challenges;

import com.akushwah.dsalgo.hashtables.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HashChallenge2 {
    public static void main(String[] args) {
        Employee aakash = new Employee("Aakash", "Kushwah", 123);
        Employee mary = new Employee("Mary", "Smith", 223);
        Employee john = new Employee("John", "Millman", 224);
        Employee mike = new Employee("Mike", "Ross", 225);

        LinkedList<Employee> list = new LinkedList<>();
        list.add(aakash);
        list.add(mary);
        list.add(john);
        list.add(mike);
        list.add(aakash);
        list.forEach(emp -> System.out.println(emp));


        HashMap<Integer, Employee> map = new HashMap<>();
        List<Employee> toBeRemoved = new ArrayList<>();
        for (Employee emp :
                list) {
            if (!map.containsKey(emp.getId())) {
                map.put(emp.getId(), emp);
            } else {
                toBeRemoved.add(emp);
            }
        }

        toBeRemoved.forEach(emp -> list.remove(emp));
        System.out.println("*********************");
        list.forEach(emp -> System.out.println(emp));

    }
}
