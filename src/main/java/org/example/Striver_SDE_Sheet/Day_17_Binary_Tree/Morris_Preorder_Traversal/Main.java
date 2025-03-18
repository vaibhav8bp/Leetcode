package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Morris_Preorder_Traversal;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        TreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.left != null) {
                TreeNode temp = currentNode.left;
                while (temp.right != null && temp.right != currentNode) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    // Instead of adding when found in predecessor's right we are adding when found null
                    // because preorder is Root LEFT RIGHT
                    list.add(currentNode.val);
                    temp.right = currentNode;
                    currentNode = currentNode.left;
                }
                if (temp.right == currentNode) {
                    temp.right = null;
                    currentNode = currentNode.right;
                }
            } else {
                list.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }

        return list;
    }
}

//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//
//        if (root == null) {
//            return list;
//        }
//
//        TreeNode currentNode = root;
//
//        while (currentNode != null) {
//            list.add(currentNode.val);
//            if (currentNode.left != null) {
//                TreeNode temp = currentNode.left;
//                while (temp.right != null && temp.right != currentNode) {
//                    temp = temp.right;
//                }
//                if (temp.right == null) {
//                    temp.right = currentNode;
//                    currentNode = currentNode.left;
//                }
//                if (temp.right == currentNode) {
//                    temp.right = null;
//                    currentNode = currentNode.right;
//                    // Remove recently added element as it was added again
//                    list.remove(list.size() - 1);
//                }
//            } else {
//                currentNode = currentNode.right;
//            }
//        }
//
//        return list;
//    }
//}

public class Main {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        five.right = six;
        two.left = four;
        two.right = five;
        one.left = two;
        one.right = three;
        System.out.println(new Solution().preorderTraversal(one));
    }
}
