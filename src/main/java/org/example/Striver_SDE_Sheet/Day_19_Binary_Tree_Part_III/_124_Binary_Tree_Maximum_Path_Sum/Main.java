package org.example.Striver_SDE_Sheet.Day_19_Binary_Tree_Part_III._124_Binary_Tree_Maximum_Path_Sum;


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

    private int answer = Integer.MIN_VALUE;

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursion is working like for current root. What is the maximum path sum it can form
        // Root has to be included at all cost.
        // So we will return the max of all nodes.

        // Taking max with 0 because if left sum is -ve we will not take it at all.
        int leftMaxPathSum = Math.max(maxPathSumHelper(root.left), 0);
        int rightMaxPathSum = Math.max(maxPathSumHelper(root.right), 0);

        answer = Math.max(answer, root.val + leftMaxPathSum + rightMaxPathSum);

        return (root.val + Math.max(leftMaxPathSum, rightMaxPathSum));
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
