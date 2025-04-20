package org.example.Striver_SDE_Sheet.Day_20_Binary_Search_Tree._700_Search_In_A_Binary_Search_Tree;

// https://leetcode.com/problems/search-in-a-binary-search-tree/description/
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
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }

        return searchBST(root.left, val);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
