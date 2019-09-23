package com.akushwah.practice.ds;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeSol1 {

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void preOrder(Node root) {
        if(root!=null){
            System.out.print(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {
        if(root!=null){

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public void verticalOrderTraversal(Node root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        getVerticalOrder(root, map, 0);
        map.forEach((k, v) -> {
            v.forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
    }

    private static void getVerticalOrder(Node node, TreeMap<Integer, List<Integer>> map, int hd) {
        if (node == null) return;
        List<Integer> hdValues = map.get(hd);
        if (hdValues == null) {
            hdValues = new LinkedList<>();
        }
        hdValues.add(node.data);
        map.put(hd, hdValues);

        getVerticalOrder(node.left, map, hd-1);
        getVerticalOrder(node.right, map, hd+1);

    }

    public static void topView(Node root) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        getVerticalOrder(root, map, 0);
        map.forEach((k, v) -> {
            v.forEach(value -> System.out.print(value + " "));
            System.out.println();
//            if(v.get(0)>root.data){
//                Collections.sort(v, (a,b) -> Integer.valueOf(b).compareTo(Integer.valueOf(a)));
//            }

//            System.out.print(v.get(0)+" ");

        });

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}