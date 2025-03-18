package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree._94_Binary_Tree_Inorder_Traversal;

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
    // Inorder Traversal is Left Root Right
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> leftList = inorderTraversal(root.left);
        List<Integer> rightList = inorderTraversal(root.right);


        leftList.add(root.val);
        leftList.addAll(rightList);

        return leftList;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
