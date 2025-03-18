package org.example.Random;

// https://leetcode.com/problems/house-robber-iii/description/

import java.util.HashMap;
import java.util.Map;

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

public class _337_House_Robber_III {

    private final Map<TreeNode, Integer> dp = new HashMap<>();

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (dp.containsKey(root)) {
            return dp.get(root);
        }

        // Exclude Current House
        int excludeCurrentHouse = rob(root.left) + rob(root.right);

        // Include Current House

        int lootLeftChildLeftChildren = (root.left == null) ? 0 : rob(root.left.left);
        int lootLeftChildRightChildren = (root.left == null) ? 0 : rob(root.left.right);

        int lootRightChildLeftChildren = (root.right == null) ? 0 : rob(root.right.left);
        int lootRightChildRightChildren = (root.right == null) ? 0 : rob(root.right.right);

        int includeCurrentHouse = root.val + lootLeftChildLeftChildren + lootLeftChildRightChildren + lootRightChildLeftChildren + lootRightChildRightChildren;

        dp.put(root, Math.max(includeCurrentHouse, excludeCurrentHouse));
        return dp.get(root);
    }
}
