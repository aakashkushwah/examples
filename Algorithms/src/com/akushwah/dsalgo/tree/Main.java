package com.akushwah.dsalgo.tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);

        tree.inOrderTraversal(tree.getRoot());
        System.out.println();
        tree.preOrderTraversal(tree.getRoot());
        System.out.println();
        tree.postOrderTraversal(tree.getRoot());
        System.out.println();
        System.out.println(tree.get(27));
        System.out.println(tree.get(10));
        System.out.println(tree.min());
        System.out.println(tree.max());
        tree.inOrderTraversal(tree.getRoot());
        System.out.println();
        System.out.println(tree.maxDepth(tree.getRoot()));
        tree.levelOrderTraversal();
        System.out.println("***********");
        tree.verticalOrderTraversal();

    }
}
