package com.akushwah.dsalgo.doublylinkedlist;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee aakash = new Employee("Aakash", "Kushwah", 123);
        Employee mary = new Employee("Mary","Smith", 223);
        Employee john = new Employee("John","Millman", 224);
        Employee mike = new Employee("Mike", "Ross", 225);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        System.out.println(list.isEmpty());
        list.addToFront(aakash);
        list.addToFront(mary);
        list.addToEnd(john);
//        System.out.println(list.getSize());
//        list.printList();
//        list.deleteFromFront();
//        list.printList();
//        list.removeNodeTail();
//        list.printList();
        list.addBefore(aakash, mike);
        list.printList();
    }
}
