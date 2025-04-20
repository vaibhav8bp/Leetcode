package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Morris_Inorder_Traversal;

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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val;
    }
}

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
class Solution {
    // Inorder Traversal is Left Root Right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTraversalList = new ArrayList<>();

        if (root == null) {
            return inorderTraversalList;
        }

        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.left != null) {
                // Attach right most node to root
                TreeNode temp = currentNode.left;
                while (temp.right != null && temp.right != currentNode) {
                    temp = temp.right;
                }

                // Did not find temp's right therefore attach to currentNode
                if (temp.right == null) {
                    temp.right = currentNode;
                    currentNode = currentNode.left;
                }
                // If found in right currentNode detach it and move to currentNode's right
                if (temp.right == currentNode) {
                    temp.right = null;
                    inorderTraversalList.add(currentNode.val);
                    currentNode = currentNode.right;
                }
            } else {
                inorderTraversalList.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }

        return inorderTraversalList;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        five.right = six;
        two.left = four;
        two.right = five;
        one.left = two;
        one.right = three;
        System.out.println(new Solution().inorderTraversal(one));
    }
}
