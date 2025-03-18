package org.example.Striver_SDE_Sheet.Day_18_Binary_Tree_Part_II._543_Diameter_Of_Binary_Tree;

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
    int diameter;

    public Helper(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

class Solution {

    private Helper diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return new Helper(0, 0);
        }

        Helper left = diameterOfBinaryTreeHelper(root.left);
        Helper right = diameterOfBinaryTreeHelper(root.right);

        int height = 1 + Math.max(left.height, right.height);
        int diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));

        return new Helper(height, diameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeHelper(root).diameter;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
