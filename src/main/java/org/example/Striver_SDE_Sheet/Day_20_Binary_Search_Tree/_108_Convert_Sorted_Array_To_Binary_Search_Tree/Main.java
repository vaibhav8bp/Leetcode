package org.example.Striver_SDE_Sheet.Day_20_Binary_Search_Tree._108_Convert_Sorted_Array_To_Binary_Search_Tree;


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

    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int mid = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, startIndex, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, endIndex);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
