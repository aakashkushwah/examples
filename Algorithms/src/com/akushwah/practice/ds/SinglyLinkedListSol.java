package com.akushwah.practice.ds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class SinglyLinkedListSol {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }


    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            if(head == null){
                return newNode;
            }
            SinglyLinkedListNode cur = head;
            SinglyLinkedListNode pre = null;

            while(cur!=null){
                pre = cur;
                cur = cur.next;
            }
            pre.next = newNode;
            return head;

    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(head == null){
            return newNode;
        }
        newNode.next = head;
        return newNode;

    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(position == 0){
            newNode.next = head;
            return newNode;
        }
        SinglyLinkedListNode cur = head;
        SinglyLinkedListNode pre = null;
        int j = 0;
        while(cur!=null && j<position){
            pre = cur;
            cur = cur.next;
            j++;
        }
        pre.next = newNode;
        newNode.next = cur;
        return head;

    }

    static void reversePrint(SinglyLinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode cur = head;
        while(cur!=null){
            stack.push(cur.data);
            cur = cur.next;
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode cur = head;
        while(cur!=null){
            stack.push(cur.data);
            cur = cur.next;
        }
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(stack.pop());
        cur = newHead;
        while(!stack.isEmpty()){
            cur.next = new SinglyLinkedListNode(stack.pop());
            cur = cur.next;
        }
        return newHead;

    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode cur1 = head1;
        SinglyLinkedListNode cur2 = head2;
        while(cur1!=null && cur2!=null){
            if(cur1.data != cur2.data){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
            if(cur1 == null && cur2 != null){
                return false;
            }else if(cur1 !=null && cur2 == null){
                return false;
            }
        }

        return true;

    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(position == 0){
            return head.next;
        }

        SinglyLinkedListNode cur = head;
        SinglyLinkedListNode pre = null;
        int j = 0;
        while(cur!=null && j<position){
            pre = cur;
            cur = cur.next;
            j++;
        }

        pre.next = cur.next;
        return head;

    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode cur = head;
        while(cur!=null){
            stack.push(cur.data);
            cur = cur.next;
        }

        int j = 0;
        if(positionFromTail == 0){
            return stack.pop();
        }
        int res = 0;
        while(!stack.isEmpty() && j<=positionFromTail){
            res = stack.pop();
            j++;
        }
        return res;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        HashSet<SinglyLinkedListNode> s = new HashSet<>();
        SinglyLinkedListNode  h = head1;
        while (h != null) {
            s.add(h);

            h = h.next;
        }

        SinglyLinkedListNode h2 = head2;
        while(h2!=null){
            if (s.contains(h2))
                return h2.data;
            h2 = h2.next;
        }
        return 0;
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        HashSet<SinglyLinkedListNode> s = new HashSet<>();
        SinglyLinkedListNode  h = head;
        while (h != null) {
            if (s.contains(h))
                return true;

            s.add(h);

            h = h.next;
        }

        return false;
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode cur = head;
        while(cur!=null){
            SinglyLinkedListNode next = cur.next;
            if(next!=null){
                if(cur.data == next.data){
                    cur.next = next.next;
                }else{
                    cur = cur.next;
                }
            }else{
                break;
            }
        }
        return head;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode cur1 = head1;
        SinglyLinkedListNode cur2 = head2;
        if(cur1.data <=cur2.data){
            head = new SinglyLinkedListNode(cur1.data);
            cur1 = cur1.next;
        } else{
            head = new SinglyLinkedListNode(cur2.data);
            cur2 = cur2.next;
        }
        SinglyLinkedListNode cur = head;
        while(cur1!=null && cur2!=null){
            if(cur1.data <= cur2.data){
                cur.next = new SinglyLinkedListNode(cur1.data);
                cur1 = cur1.next;
            } else {
                cur.next = new SinglyLinkedListNode(cur2.data);
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        while(cur1!=null){
            cur.next = new SinglyLinkedListNode(cur1.data);
            cur = cur.next;
            cur1 = cur1.next;
        }

        while(cur2!=null){
            cur.next = new SinglyLinkedListNode(cur2.data);
            cur = cur.next;
            cur2 = cur2.next;
        }

        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

            llist.head = llist_head;
        }


        printSinglyLinkedList(llist.head, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
