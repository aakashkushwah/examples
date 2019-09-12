package com.akushwah.dsalgo.hashtables;

public class Main {
    public static void main(String[] args) {
        Employee aakash = new Employee("Aakash", "Kushwah", 123);
        Employee mary = new Employee("Mary","Smith", 223);
        Employee john = new Employee("John","Millman", 224);
        Employee mike = new Employee("Mike", "Ross", 225);
        SimpleHashTable<String, Employee> sh = new SimpleHashTable<>();
        sh.put("Aakash", aakash);
        sh.put("Mary", mary);
        sh.put("John", john);
        sh.printHashTable();
        System.out.println(sh.get("Mary"));

        System.out.println("*****************");

        SimpleHashTableLP<String, Employee> slp = new SimpleHashTableLP<>();
        slp.put("Aakash", aakash);
        slp.put("Mary", mary);
        slp.put("John", john);
        slp.printHashTable();
        slp.remove("John");
        slp.printHashTable();
        System.out.println(slp.get("Mary"));
        System.out.println("*********************");


        SimpleHashTableChaining<String, Employee> sc = new SimpleHashTableChaining<>();
        sc.put("Aakash", aakash);
        sc.put("Mary", mary);
        sc.put("John", john);
        sc.printHashTable();
        sc.remove("John");
        sc.printHashTable();
        System.out.println(sc.get("Mary"));
        System.out.println("*********************");


    }

}
