package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II._1373_Maximum_Sum_BST_In_Binary_Tree;

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/
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
    int sumOfAllNodes;
    boolean isBST;
    int minOfTree;
    int maxOfTree;

    public Helper(int sumOfAllNodes, boolean isBST, int minOfTree, int maxOfTree) {
        this.sumOfAllNodes = sumOfAllNodes;
        this.isBST = isBST;
        this.minOfTree = minOfTree;
        this.maxOfTree = maxOfTree;
    }
}

class Solution {

    int maximumSum = 0;

    private Helper maxSumBSTHelper(TreeNode root) {
        if (root == null) {
            return new Helper(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Helper left = maxSumBSTHelper(root.left);
        Helper right = maxSumBSTHelper(root.right);

        boolean isBST = left.isBST && right.isBST && !((root.val <= left.maxOfTree) || (root.val >= right.minOfTree));

        int currentSum = root.val + left.sumOfAllNodes + right.sumOfAllNodes;
        if (isBST) {
            maximumSum = Math.max(maximumSum, currentSum);
        }

        int min = Math.min(root.val, Math.min(left.minOfTree, right.minOfTree));
        int max = Math.max(root.val, Math.max(left.maxOfTree, right.maxOfTree));

        return new Helper(currentSum, isBST, min, max);
    }

    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return maximumSum;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}