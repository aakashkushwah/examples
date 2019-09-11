package com.company.test2.doublylinkedlist;

public class EmployeeDoublyLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public boolean addBefore(Employee employee, Employee newEmployee){
        if(head == null) return false;
        EmployeeNode current = head;
        while(current !=null && !current.getEmployee().equals(employee)){
            current = current.getNext();
        }
        if(current!=null){
            EmployeeNode node = new EmployeeNode(newEmployee);
            node.setPrevious(current.getPrevious());
            node.setNext(current);
            current.setPrevious(node);
            if(head != current){
                node.getPrevious().setNext(node);
            } else{
                head = node;
            }
            size++;
            return true;
        }else{
            System.out.println("Element does not exist");
            return false;
        }
    }

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        if(head == null){
            tail = node;
        }else{
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        if(tail == null){
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public EmployeeNode deleteFromFront(){
        if(isEmpty())
            return null;
        EmployeeNode removedNode = head;
        if(head.getNext() == null){
            tail = null;
        } else{
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        removedNode.setPrevious(null);
        return removedNode;
    }

    public EmployeeNode removeNodeTail(){
        if(isEmpty())
            return null;
        EmployeeNode removedNode = head;
        if(tail.getPrevious() == null){
            head = null;
        } else{
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setNext(null);
        removedNode.setPrevious(null);
        return removedNode;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD <=>");
        while (current!=null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
