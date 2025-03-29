package org.example.Random;

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

// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
public class _2096_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another {

    /*
        5
       / \
      3   8
     / \   \
    2   4   10
             \
             12

    Let's say we have to find 4 and 12.
    Find path of 4 and 12 from root itself.
    LR
    RRR
    Remove common prefix from both leftPath and rightPath.
    after that replace leftpath with U's and simply append rightPath.
 */

    static StringBuilder pathFromRootToTarget(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return new StringBuilder();
        }

        StringBuilder leftPath = pathFromRootToTarget(root.left, target);

        if (leftPath != null) {
            leftPath.append('L');
            return leftPath;
        }

        StringBuilder rightPath = pathFromRootToTarget(root.right, target);

        if (rightPath != null) {
            rightPath.append('R');
            return rightPath;
        }

        return null;
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder leftPath = pathFromRootToTarget(root, startValue).reverse();
        StringBuilder rightPath = pathFromRootToTarget(root, destValue).reverse();

        int leftPathIndex = 0;
        int rightPathIndex = 0;

        while (leftPathIndex < leftPath.length() && rightPathIndex < rightPath.length() && leftPath.charAt(leftPathIndex) == rightPath.charAt(rightPathIndex)) {
            leftPathIndex++;
            rightPathIndex++;
        }

        return "U".repeat(Math.max(0, leftPath.length() - leftPathIndex)) + rightPath.substring(rightPathIndex);
    }

//    private TreeNode getLCA(TreeNode root, int startValue, int destValue) {
//        if (root == null || root.val == startValue || root.val == destValue) {
//            return root;
//        }
//
//        TreeNode left = getLCA(root.left, startValue, destValue);
//        TreeNode right = getLCA(root.right, startValue, destValue);
//
//        if (left != null && right != null) {
//            return root;
//        } else if (left != null) {
//            return left;
//        } else {
//            return right;
//        }
//    }
//
//    private int depthOfNodeFromRoot(TreeNode root, int target) {
//        if (root == null) {
//            return -1;
//        }
//
//        if (root.val == target) {
//            return 0;
//        }
//
//        int left = depthOfNodeFromRoot(root.left, target);
//        if (left != -1) {
//            return 1 + left;
//        }
//        int right = depthOfNodeFromRoot(root.right, target);
//        if (right != -1) {
//            return 1 + right;
//        }
//        return -1;
//    }
//
//    private StringBuilder getPathFromRootToNode(TreeNode root, int target) {
//        if (root == null) {
//            return null;
//        }
//
//        if (root.val == target) {
//            return new StringBuilder();
//        }
//
//        StringBuilder leftPath = getPathFromRootToNode(root.left, target);
//
//        if (leftPath != null) {
//            leftPath.append("L");
//            return leftPath;
//        }
//
//        StringBuilder rightPath = getPathFromRootToNode(root.right, target);
//
//        if (rightPath != null) {
//            rightPath.append("R");
//            return rightPath;
//        }
//
//        return null;
//    }
//
//    public String getDirections(TreeNode root, int startValue, int destValue) {
//        TreeNode lca = getLCA(root, startValue, destValue);
//        int distanceOfLCAToStart = depthOfNodeFromRoot(lca, startValue);
//        return "U".repeat(Math.max(0, distanceOfLCAToStart)) +
//                getPathFromRootToNode(lca, destValue).reverse();
//    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        five.left = one;
        five.right = two;
        one.left = three;
        two.left = six;
        two.right = four;

        System.out.println(getDirections(five, 3, 6));
    }
}