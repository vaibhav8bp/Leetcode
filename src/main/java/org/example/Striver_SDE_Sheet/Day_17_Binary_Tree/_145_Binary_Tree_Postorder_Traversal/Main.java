package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree._145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-postorder-traversal/description/
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


class Solution {
    // Post Order Traversal Is Left Right Root
    public void postorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorderTraversalHelper(root.left, list);
        postorderTraversalHelper(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalHelper(root, list);
        return list;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
