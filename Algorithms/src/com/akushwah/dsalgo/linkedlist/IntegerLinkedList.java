package com.akushwah.dsalgo.linkedlist;

public class IntegerLinkedList {
    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        this.head = node;
        size++;
    }

    public void insertSorted(Integer value) {
        if (head == null || head.getValue() >= value) {
            addToFront(value);
            return;
        }
        IntegerNode currentNode = head.getNext();
        IntegerNode previous = head;
        while(currentNode!=null && currentNode.getValue()<value){
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        IntegerNode node = new IntegerNode(value);
        node.setNext(currentNode);
        previous.setNext(node);
        size++;

//        while (currentNode != null ) {
//            size++;
//            IntegerNode node = new IntegerNode(value);
//            IntegerNode rightNode = currentNode.getNext();
//            if (rightNode == null) {
//                if (currentNode.getValue() > value) {
//                    node.setNext(head);
//                    head = node;
//                } else {
//                    currentNode.setNext(node);
//                }
//                break;
//            } else if (currentNode.getValue() <= value && value < rightNode.getValue()) {
//                node.setNext(currentNode.getNext());
//                currentNode.setNext(node);
//                break;
//            } else {
//                currentNode = currentNode.getNext();
//            }
//        }
    }

    public IntegerNode remove() {
        if (isEmpty())
            return null;
        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD ->");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
