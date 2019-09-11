package com.company.test2.linkedlist;

public class IntegerNode {
    private Integer value;
    private IntegerNode next;

    public IntegerNode(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
