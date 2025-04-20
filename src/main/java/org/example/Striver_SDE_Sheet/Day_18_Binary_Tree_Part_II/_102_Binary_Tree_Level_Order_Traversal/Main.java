package org.example.Striver_SDE_Sheet.Day_18_Binary_Tree_Part_II._102_Binary_Tree_Level_Order_Traversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> finalList = new ArrayList<>();

        if (root == null) {
            return finalList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> levelList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode front = queue.remove();
            if (front != null) {
                levelList.add(front.val);
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            } else {

                finalList.add(levelList);

                if (queue.isEmpty()) {
                    break;
                }

                queue.add(null);
                levelList = new ArrayList<>();
            }
        }

        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
