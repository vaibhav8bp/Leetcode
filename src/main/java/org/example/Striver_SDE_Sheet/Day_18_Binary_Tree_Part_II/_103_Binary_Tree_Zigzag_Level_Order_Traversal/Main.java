package org.example.Striver_SDE_Sheet.Day_18_Binary_Tree_Part_II._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.*;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> finalList = new ArrayList<>();

        if (root == null) {
            return finalList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 0;

        List<Integer> currentLevelList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode front = queue.remove();
            if (front != null) {
                currentLevelList.add(front.val);
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            } else {
                // For even level traverse left to right
                // For odd level traverse right to left

                if (level % 2 != 0) {
                    Collections.reverse(currentLevelList);
                }

                finalList.add(currentLevelList);

                if (queue.isEmpty()) {
                    break;
                }
                currentLevelList = new ArrayList<>();
                level++;
                queue.add(null);
            }

        }

        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
