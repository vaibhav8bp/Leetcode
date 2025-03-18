package org.example.Striver_SDE_Sheet.Day_19_Binary_Tree_Part_III._106_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal;


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

// Inorder is Left Root Right
// Postorder is Left Right Root

class Solution {
    private TreeNode buildTree(int[] inorder, int[] postorder, int postStart, int postEnd, int inStart, int inEnd) {
        if ((inStart > inEnd) || (postStart > postEnd)) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int index = inStart;
        while (inorder[index] != postorder[postEnd]) {
            index++;
        }

        root.left = buildTree(inorder, postorder, postStart, index - 1 - inStart + postStart, inStart, index - 1);
        root.right = buildTree(inorder, postorder, postEnd - inEnd + index, postEnd - 1, index + 1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
