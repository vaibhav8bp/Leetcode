package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Preorder_Inorder_Postorder_In_A_Single_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://www.naukri.com/code360/problems/981269
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
};

class Helper {
    TreeNode node;
    int position;

    public Helper(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }
}

class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {

        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        List<List<Integer>> finalList = new ArrayList<>();

        finalList.add(inOrderList);
        finalList.add(preOrderList);
        finalList.add(postOrderList);


        if (root == null) {
            return finalList;
        }

        Stack<Helper> stack = new Stack<>();
        stack.add(new Helper(root, 1));

        while (!stack.isEmpty()) {
            Helper top = stack.pop();
            if (top.position == 1) {
                preOrderList.add(top.node.data);
                // Same node pushed with position=2
                stack.add(new Helper(top.node, 2));
                // If left node is there add it
                if (top.node.left != null) {
                    stack.add(new Helper(top.node.left, 1));
                }
            } else if (top.position == 2) {
                inOrderList.add(top.node.data);
                // Same node pushed with position=3
                stack.add(new Helper(top.node, 3));
                // If right node is there add it
                if (top.node.right != null) {
                    stack.add(new Helper(top.node.right, 1));
                }
            } else if (top.position == 3) {
                postOrderList.add(top.node.data);
            }
        }

        return finalList;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}