package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II._653_Two_Sum_IV_Input_Is_A_BST;


import java.util.ArrayList;
import java.util.List;

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

    private void formSortedArray(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        formSortedArray(root.left, list);
        list.add(root.val);
        formSortedArray(root.right, list);
    }

    public boolean findTarget(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        formSortedArray(root, list);

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int currentSum = list.get(start) + list.get(end);

            if (currentSum == k) {
                return true;
            } else if (currentSum < k) {
                start++;
            } else {
                end--;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
