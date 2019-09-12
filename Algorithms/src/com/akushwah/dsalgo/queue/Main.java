package com.akushwah.dsalgo.queue;

import com.akushwah.dsalgo.stack.LinkedStack;

public class Main {
    public static void main(String[] args) {
        Employee aakash = new Employee("Aakash", "Kushwah", 123);
        Employee mary = new Employee("Mary","Smith", 223);
        Employee john = new Employee("John","Millman", 224);
        Employee mike = new Employee("Mike", "Ross", 225);

        ArrayQueue<Employee> queue = new ArrayQueue<>(3);
        queue.add(aakash);
        queue.add(mary);
        queue.add(john);
        queue.add(mike);
        queue.remove();
        queue.printQueue();

        System.out.println(checkForPalindrome("Racecar"));
        System.out.println(checkForPalindrome("Hello"));
    }

    public static boolean checkForPalindrome(String str){
        LinkedStack<Character> stack = new LinkedStack<>();
        ArrayQueue<Character> queue= new ArrayQueue<>(str.length());
        String lower = str.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if(c>='a' && c<='z'){
                stack.push(c);
                queue.add(c);
            }
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.remove())){
                return false;
            }
        }
        return true;
    }
}
