package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II._230_Kth_Smallest_Element_In_A_BST;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
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

    int count = 0;
    int answer = 0;

    private void kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        kthSmallestHelper(root.left, k);
        count++;
        if (count == k) {
            answer = root.val;
            return;
        }
        kthSmallestHelper(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        kthSmallestHelper(root, k);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
