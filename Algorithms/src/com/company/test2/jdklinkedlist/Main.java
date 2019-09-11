package com.company.test2.jdklinkedlist;

import com.company.test2.linkedlist.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee aakash = new Employee("Aakash", "Kushwah", 123);
        Employee mary = new Employee("Mary","Smith", 223);
        Employee john = new Employee("John","Millman", 224);
        Employee mike = new Employee("Mika","Ross", 225);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(aakash);
        list.addFirst(mary);
        list.addFirst(john);

        printList(list);
        list.add(mike);
        printList(list);

        list.removeFirst();
        printList(list);
        list.removeLast();
        printList(list);


//        for (Employee emp: list
//             ) {
//            System.out.println(emp);
//        }

    }

    public static void printList(LinkedList<Employee> list){
        Iterator<Employee> iter = list.iterator();
        System.out.print("head <=> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");
    }
}
