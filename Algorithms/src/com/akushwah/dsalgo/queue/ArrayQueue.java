package com.akushwah.dsalgo.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> {
    private T[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    public void add(T t) {
        if (size() == queue.length - 1) {
            System.out.println("Resizing");
            int numSize = size();
            T[] newArr = (T[]) new Object[2 * queue.length];
            System.arraycopy(queue, front, newArr, 0, queue.length-front);
            System.arraycopy(queue,0, newArr, queue.length-front, back);
            queue = newArr;
            front =0;
            back = numSize;
        }
//        if (back == queue.length) {
//            System.out.println("Resizing");
//            T[] newArr = (T[]) new Object[2 * queue.length];
//            System.arraycopy(queue, 0, newArr, 0, queue.length);
//            queue = newArr;
//        }
        queue[back] = t;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if(front<=back){
            return back-front;
        }else{
            return back-front+queue.length;
//            return queue.length - (front - back); --my implementation basically the same
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T t = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }else if(front == queue.length-1){
            front = 0;
        }
        return t;
    }

    public void printQueue() {
        if(front<=back){
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }else{
            for (int i = front; i <queue.length ; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i <back ; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}
