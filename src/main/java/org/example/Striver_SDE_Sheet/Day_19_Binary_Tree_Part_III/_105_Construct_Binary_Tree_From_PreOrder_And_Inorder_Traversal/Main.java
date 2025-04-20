package org.example.Striver_SDE_Sheet.Day_19_Binary_Tree_Part_III._105_Construct_Binary_Tree_From_PreOrder_And_Inorder_Traversal;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
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

// Preorder is Root Left Right
// Inorder is Left Root Right

class Solution {

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if ((preStart > preEnd) || (inStart > inEnd)) {
            return null;
        }

        // Root Will be the preStart of preOrder
        TreeNode root = new TreeNode(preorder[preStart]);

        int index = inStart;

        while (inorder[index] != preorder[preStart]) {
            index++;
        }

        root.left = buildTree(preorder, inorder, preStart + 1, index - inStart + preStart, inStart, index - 1);
        root.right = buildTree(preorder, inorder, preEnd - inEnd + index + 1, preEnd, index + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
