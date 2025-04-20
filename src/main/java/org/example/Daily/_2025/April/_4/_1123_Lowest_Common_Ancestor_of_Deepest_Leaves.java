package org.example.Daily._2025.April._4;

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

// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
public class _1123_Lowest_Common_Ancestor_of_Deepest_Leaves {

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    private TreeNode dfs(TreeNode root, int currentDepth, int maxDepth) {
        if (root == null) {
            return null;
        }

        // Next node will be leaf node, so LCA will be current node.
        if (currentDepth == (maxDepth - 1)) {
            return root;
        }

        TreeNode leftTree = dfs(root.left, currentDepth + 1, maxDepth);
        TreeNode rightTree = dfs(root.right, currentDepth + 1, maxDepth);

        if (leftTree != null && rightTree != null) {
            return root;
        } else if (leftTree == null && rightTree != null) {
            return rightTree;
        } else return leftTree;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root, 0, getMaxDepth(root));
    }

//    int maxDepth = -1;
//
//    private void findDeepestLeaves(TreeNode root, int currentDepth, List<TreeNode> leafNodes) {
//        if (root == null) {
//            return;
//        }
//
//        if (currentDepth >= maxDepth) {
//            if (currentDepth > maxDepth) {
//                leafNodes.clear();
//            }
//            leafNodes.add(root);
//            maxDepth = currentDepth;
//        }
//
//        findDeepestLeaves(root.left, currentDepth + 1, leafNodes);
//        findDeepestLeaves(root.right, currentDepth + 1, leafNodes);
//    }
//
//    private TreeNode getLCA(TreeNode root, TreeNode left, TreeNode right) {
//        if (root == null || root == left || root == right) {
//            return root;
//        }
//
//        TreeNode leftTree = getLCA(root.left, left, right);
//        TreeNode rightTree = getLCA(root.right, left, right);
//
//        if (leftTree != null && rightTree != null) {
//            return root;
//        } else if (leftTree == null && rightTree != null) {
//            return rightTree;
//        } else return leftTree;
//    }
//
//    public TreeNode lcaDeepestLeaves(TreeNode root) {
//        List<TreeNode> leafNodes = new ArrayList<>();
//        findDeepestLeaves(root, 0, leafNodes);
//
//        if (leafNodes.isEmpty()) {
//            return null;
//        } else if (leafNodes.size() == 1) {
//            return leafNodes.getFirst();
//        } else {
//
//            TreeNode lca = getLCA(root, leafNodes.getFirst(), leafNodes.get(1));
//
//            for (int i = 2; i < leafNodes.size(); i++) {
//                lca = getLCA(root, lca, leafNodes.get(i));
//            }
//
//            return lca;
//        }
//    }


    // 1,2,null,3,4,null,6,null,5
}