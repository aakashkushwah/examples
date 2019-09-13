package com.akushwah.dsalgo.heap;

import com.akushwah.dsalgo.hashtables.Employee;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap();
        System.out.println(heap.peek());
        heap.delete(0);
        heap.printHeap();
        System.out.println(heap.peek());

        PriorityQueue<Employee> pq = new PriorityQueue<>((o1, o2) -> Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o2.getId())));
        Employee aakash = new Employee("Aakash", "Kushwah", 4);
        Employee mary = new Employee("Mary","Smith", 67);
        Employee john = new Employee("John","Millman", 12);
        Employee mike = new Employee("Mike", "Ross", 45);
        pq.add(aakash);
        pq.add(mary);
        pq.add(john);
        pq.add(mike);
        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq.peek());
        System.out.println("***************");
        pq.forEach(System.out::println);
    }
}
