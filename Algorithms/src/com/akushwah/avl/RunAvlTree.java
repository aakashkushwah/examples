package com.akushwah.avl;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jay
 */
public class RunAvlTree {
    public static void main(String[] args) {
        Tree<Integer> avlTree = new AvlTree<>();

        // Left heavy situation
        /*avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(23);
        avlTree.insert(13);
        avlTree.insert(25);
        avlTree.insert(2);
        avlTree.insert(9);
        avlTree.insert(8);
        avlTree.insert(7);
*/

        // Left heavy situation
        avlTree.insert(1);
        avlTree.traverse();
        avlTree.insert(2);
        avlTree.traverse();
        avlTree.insert(3);
        avlTree.traverse();
        avlTree.insert(4);
        avlTree.traverse();
        avlTree.insert(5);
        avlTree.traverse();
        avlTree.insert(6);
        avlTree.traverse();
        avlTree.insert(7);

        avlTree.traverse();


        avlTree.remove(7);

        avlTree.traverse();

        avlTree.remove(4);

        avlTree.remove(5);
        avlTree.remove(6);


        avlTree.traverse();
        
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    }
}
