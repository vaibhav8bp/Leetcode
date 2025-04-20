package org.example.Striver_SDE_Sheet.Day_20_Binary_Search_Tree._98_Validate_Binary_Search_Tree;

// https://leetcode.com/problems/validate-binary-search-tree/description/
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

    private boolean isValidBST(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (!(root.val < max && root.val > min)) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
