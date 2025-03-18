package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II._173_Binary_Search_Tree_Iterator;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {

    int currentPointer = -1;
    List<Integer> list;

    private void populateList(TreeNode root) {
        if (root == null) {
            return;
        }
        populateList(root.left);
        list.add(root.val);
        populateList(root.right);
    }

    public BSTIterator(TreeNode root) {
        currentPointer = -1;
        list = new ArrayList<>();
        populateList(root);
    }

    public int next() {
        currentPointer++;
        return list.get(currentPointer);
    }

    public boolean hasNext() {
        return (currentPointer < list.size() - 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
