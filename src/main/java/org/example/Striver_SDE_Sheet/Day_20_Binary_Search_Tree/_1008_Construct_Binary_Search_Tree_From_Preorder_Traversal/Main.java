package org.example.Striver_SDE_Sheet.Day_20_Binary_Search_Tree._1008_Construct_Binary_Search_Tree_From_Preorder_Traversal;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
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

    private TreeNode bstFromPreorder(int[] preorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startIndex]);

        int index = startIndex + 1;

        while (index < endIndex && preorder[index] < preorder[startIndex]) {
            index++;
        }

        root.left = bstFromPreorder(preorder, startIndex + 1, index - 1);
        root.right = bstFromPreorder(preorder, index, endIndex);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
