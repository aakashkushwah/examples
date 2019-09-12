package com.akushwah.dsalgo.stack;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack<T> {
    private LinkedList<T> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    public void push(T t) {
        stack.push(t);
    }

    public T pop() {
        return stack.pop();
    }

    public int size(){
        return stack.size();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<T> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Alternate Print");
        for (T t:stack) {
            System.out.println(t);
        }
    }

}
