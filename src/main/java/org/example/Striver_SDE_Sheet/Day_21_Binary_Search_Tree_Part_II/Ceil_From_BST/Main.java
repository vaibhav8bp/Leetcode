package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II.Ceil_From_BST;

// https://www.naukri.com/code360/problems/ceil-from-bst_920464
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

class Solution {

    private static int successor = -1;

    private static void findCeilHelper(TreeNode<Integer> node, int x) {
        if (node == null) {
            return;
        }

        if (node.data >= x) {
            successor = node.data;
            if (node.data == x) {
                return;
            }
            findCeilHelper(node.left, x);
        } else {
            findCeilHelper(node.right, x);
        }
    }

    public static int findCeil(TreeNode<Integer> node, int x) {
        successor = -1;
        findCeilHelper(node, x);
        return successor;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}