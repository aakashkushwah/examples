package com.akushwah.dsalgo.tree;

import java.util.*;

public class Tree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    public void preOrderTraversal(TreeNode node) {
        node.preOrderTraversal();
    }

    public void postOrderTraversal(TreeNode node) {
        node.postOrderTraversal();

    }

    public void inOrderTraversal(TreeNode node) {
        node.inOrderTraversal();
    }

    public void levelOrderTraversal() {
        int depth = maxDepth(root);
        for (int i = 1; i <= depth; i++) {
            levelOrderTraversal(root, i);
            System.out.println();
        }
    }

    private void levelOrderTraversal(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == 1) {
            System.out.print(node.getData() + " ");
        } else {
            levelOrderTraversal(node.getLeftChild(), depth - 1);
            levelOrderTraversal(node.getRightChild(), depth - 1);
        }
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.getRightChild()), maxDepth(node.getLeftChild())) + 1;
    }

    public void verticalOrderTraversal() {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        getVerticalOrder(root, map, 0);
        map.forEach((k, v) -> {
            v.forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
    }

    private void getVerticalOrder(TreeNode node, TreeMap<Integer, List<Integer>> map, int hd) {
        if (node == null) return;
        List<Integer> hdValues = map.get(hd);
        if (hdValues == null) {
            hdValues = new ArrayList<>();
        }
        hdValues.add(node.getData());
        map.put(hd, hdValues);

        getVerticalOrder(node.getLeftChild(), map, hd-1);
        getVerticalOrder(node.getRightChild(), map, hd+1);

    }


    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {
            //case 1 and 2 node to delete has 0 to 1 child
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
            //case 3 is not leaf and has both left and right child
            //min of right subtree is selected
            int min = subtreeRoot.getRightChild().min();
            subtreeRoot.setData(min);
            //delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;
    }

    public TreeNode get(int value) {
        if (root == null) {
            return null;
        }
        return root.get(value);
    }

}
