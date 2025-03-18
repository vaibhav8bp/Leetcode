package org.example.Daily._2025.February._21;

// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

import java.util.*;

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

class FindElements {

    Map<Integer, Boolean> elements;

    public FindElements(TreeNode root) {
        elements = new HashMap<>();
        if (root != null) {
            root.val = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode front = queue.remove();
                elements.put(front.val, true);

                if (front.left != null) {
                    front.left.val = 2 * front.val + 1;
                    queue.add(front.left);
                }

                if (front.right != null) {
                    front.right.val = 2 * front.val + 2;
                    queue.add(front.right);
                }
            }
        }
    }

    public boolean find(int target) {
        return elements.containsKey(target);
    }
}

// class FindElements {

//    TreeNode root = null;

//    private boolean findHelper(TreeNode root, int target) {
//        if (root == null) {
//            return false;
//        }

//        if (root.val == target) {
//            return true;
//        }

//        return findHelper(root.left, target) || findHelper(root.right, target);
//    }

//    private TreeNode recoverTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }

//        if (root.left != null) {
//            root.left.val = 2 * root.val + 1;
//            root.left = recoverTree(root.left);
//        }

//        if (root.right != null) {
//            root.right.val = 2 * root.val + 2;
//            root.right = recoverTree(root.right);
//        }

//        return root;
//    }

//    public FindElements(TreeNode root) {
//        if (root == null) {
//            this.root = null;
//        } else {
//            root.val = 0;
//            this.root = recoverTree(root);
//        }
//    }

//    public boolean find(int target) {
//        return findHelper(root, target);
//    }
// }

public class _1261_Find_Elements_in_a_Contaminated_Binary_Tree {
}