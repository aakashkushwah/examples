package com.akushwah.dsalgo.linkedlist;

public class Main {
    public static void main(String[] args) {
//        List<Employee> employeeList = new ArrayList<>();
//        Employee aakash = new Employee("Aakash", "Kushwah", 123);
//        Employee mary = new Employee("Mary","Smith", 223);
//        Employee john = new Employee("John","Millman", 224);
//
//        EmployeeLinkedList list = new EmployeeLinkedList();
//        System.out.println(list.isEmpty());
//        list.addToFront(aakash);
//        list.addToFront(mary);
//        list.addToFront(john);
//        System.out.println(list.getSize());
//        list.printList();
//        list.removeFromFront();
//        list.printList();
//        System.out.println(list.getSize());

        IntegerLinkedList intList = new IntegerLinkedList();
        intList.insertSorted(5);
        intList.insertSorted(1);
        intList.insertSorted(2);
        intList.insertSorted(6);
        intList.insertSorted(3);
        intList.insertSorted(1);
        intList.printList();
    }
}
