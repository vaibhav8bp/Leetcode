package org.example.Weekly._419;

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

class HelperA {
    boolean isPerfectSubTree;
    int sizeOfTree;

    public HelperA(boolean isPerfectSubTree, int sizeOfTree) {
        this.isPerfectSubTree = isPerfectSubTree;
        this.sizeOfTree = sizeOfTree;
    }

    public HelperA(TreeNode node) {
        this.isPerfectSubTree = false;
        this.sizeOfTree = 0;
    }
}

class SolutionA {
    List<Integer> perfectTreeSizeList = new ArrayList<>();

    private HelperA isPerfectSubtree(TreeNode root) {
        if (root == null) {
            return new HelperA(true, 0);
        }

        // Both Null
        if (root.left == null && root.right == null) {
            return new HelperA(true, 1);
        }
        // Left Non Null, Right Null
        if (root.left != null && root.right == null) {
            return new HelperA(false, 0);
        }
        // Left Null, Right Non Null
        if (root.left == null && root.right != null) {
            return new HelperA(false, 0);
        }
        //
        HelperA left = isPerfectSubtree(root.left);
        HelperA right = isPerfectSubtree(root.right);

        HelperA finalHelper = new HelperA(root);

        if (left.isPerfectSubTree && right.isPerfectSubTree) {
            finalHelper.isPerfectSubTree = true;
            finalHelper.sizeOfTree = 2 * left.sizeOfTree + 1;
            perfectTreeSizeList.add(finalHelper.sizeOfTree);
        }

        return finalHelper;

    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        isPerfectSubtree(root);
        perfectTreeSizeList.sort((a, b) -> (b - a));
        if (perfectTreeSizeList.size() <= k) {
            return 0;
        }
        return perfectTreeSizeList.get(k - 1);
    }
}

public class Kth_Largest_Perfect_Subtree_Size_in_Binary_Tree {
    public static void main(String[] args) {

    }
}