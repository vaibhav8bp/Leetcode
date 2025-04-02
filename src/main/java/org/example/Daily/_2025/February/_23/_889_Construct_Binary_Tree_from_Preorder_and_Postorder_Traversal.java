package org.example.Daily._2025.February._23;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
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

// preorder =  [1,2,4,5,3,6,7]
// postorder = [4,5,2,6,7,3,1]

class Solution {

    private TreeNode constructFromPrePost(int preStart, int preEnd, int[] preorder, int postStart, int postEnd, int[] postOrder) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        if (preStart == preEnd || postStart == postEnd) {
            return root;
        }

        int leftSubTreeRoot = preorder[preStart + 1];

        int leftSubTreeRootIndexInPostOrder = postStart;

        int leftSubTreeLength = 0;
        while (postOrder[leftSubTreeRootIndexInPostOrder] != leftSubTreeRoot) {
            leftSubTreeRootIndexInPostOrder++;
            leftSubTreeLength++;
        }

        root.left = constructFromPrePost(preStart + 1, preStart + 1 + leftSubTreeLength, preorder, postStart, leftSubTreeRootIndexInPostOrder, postOrder);
        root.right = constructFromPrePost(preStart + 1 + leftSubTreeLength + 1, preEnd, preorder, leftSubTreeRootIndexInPostOrder + 1, postEnd - 1, postOrder);
        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(0, preorder.length - 1, preorder, 0, postorder.length - 1, postorder);
    }
}

public class _889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
}
