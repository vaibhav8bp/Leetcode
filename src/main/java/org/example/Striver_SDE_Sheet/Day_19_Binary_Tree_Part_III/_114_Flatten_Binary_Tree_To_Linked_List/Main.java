package org.example.Striver_SDE_Sheet.Day_19_Binary_Tree_Part_III._114_Flatten_Binary_Tree_To_Linked_List;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
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

// Morris Traversal Solution
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.left != null) {
                TreeNode temp = currentNode.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = currentNode.right;
                currentNode.right = currentNode.left;
                currentNode.left = null;
            }
            currentNode = currentNode.right;
        }
    }
}

// O(N) Stack Solution
//class Solution {
//    public void flatten(TreeNode root) {
//
//        if (root == null) {
//            return;
//        }
//
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode previous = root;
//
//        if (root.right != null) {
//            stack.add(root.right);
//        }
//        if (root.left != null) {
//            stack.add(root.left);
//        }
//
//        previous.left = previous.right = null;
//
//        while (!stack.isEmpty()) {
//            TreeNode top = stack.pop();
//
//            if (top.right != null) {
//                stack.add(top.right);
//            }
//            if (top.left != null) {
//                stack.add(top.left);
//            }
//
//            top.left = top.right = null;
//
//            previous.right = top;
//            previous = top;
//
//        }
//    }
//}

//class Solution {
//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        flatten(root.left);
//        flatten(root.right);
//
//        TreeNode right = root.right;
//
//        root.right = root.left;
//        root.left = null;
//
//        TreeNode temp = root;
//        while (temp.right != null) {
//            temp = temp.right;
//        }
//
//        temp.right = right;
//    }
//}

//[1,2,5,3,4,null,6]


public class Main {

    static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.right = six;

        new Solution().flatten(one);

        print(one);
    }
}