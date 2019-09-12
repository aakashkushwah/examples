package com.akushwah.dsalgo.stack;

import java.util.EmptyStackException;

public class ArrayStack<T> {
    private T[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = (T[]) new Object[capacity];
    }

    public void push(T t) {
        if (top == stack.length) {
            System.out.println("Resizing");
            T[] newArray = (T[]) new Object[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = t;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T t = stack[--top];
        stack[top] = null;
        return t;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
