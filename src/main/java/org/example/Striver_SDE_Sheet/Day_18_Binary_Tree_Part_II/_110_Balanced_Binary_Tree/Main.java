package org.example.Striver_SDE_Sheet.Day_18_Binary_Tree_Part_II._110_Balanced_Binary_Tree;

// https://leetcode.com/problems/balanced-binary-tree/description/
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

class Helper {
    int height;
    boolean isBalanced;

    public Helper(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

class Solution {

    public Helper isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new Helper(0, true);
        }

        Helper left = isBalancedHelper(root.left);
        Helper right = isBalancedHelper(root.right);

        int height = 1 + Math.max(left.height, right.height);
        boolean isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1);

        return new Helper(height, isBalanced);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).isBalanced;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
