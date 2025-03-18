package org.example.Daily._2025.February._22;

// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/


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
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


public class _1028_Recover_a_Tree_From_Preorder_Traversal {

    private TreeNode recoverFromPreorderHelper(StringBuilder traversal) {

        int start = 0;

        while (start < traversal.length() && traversal.charAt(start) != '-') {
            start++;
        }

        TreeNode root = new TreeNode(Integer.parseInt(traversal.substring(0, start)));

        // 1-2--3--4-5--6--7
        // Break Into 2-3-4 and 5-6-7

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        boolean leftStart = false;
        boolean rightStart = false;

        while (start < traversal.length()) {
            int end = start;

            while (end < traversal.length() && traversal.charAt(end) == '-') {
                end++;
            }

            int count = end - start - 1;
            if (count == 0) {
                if (!leftStart) {
                    leftStart = true;
                } else {
                    rightStart = true;
                }
            }
            if (!rightStart) {
                left.append("-".repeat(count));
                while (end < traversal.length() && traversal.charAt(end) != '-') {
                    left.append(traversal.charAt(end));
                    end++;
                }
            } else {
                right.append("-".repeat(count));
                while (end < traversal.length() && traversal.charAt(end) != '-') {
                    right.append(traversal.charAt(end));
                    end++;
                }
            }

            start = end;
        }

        if (!left.isEmpty()) {
            root.left = recoverFromPreorderHelper(left);
        }
        if (!right.isEmpty()) {
            root.right = recoverFromPreorderHelper(right);
        }

        return root;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        return recoverFromPreorderHelper(new StringBuilder(traversal));
    }
}
