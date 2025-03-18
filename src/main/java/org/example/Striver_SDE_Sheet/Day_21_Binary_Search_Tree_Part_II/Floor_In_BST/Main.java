package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II.Floor_In_BST;


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

    static int predecessor = 0;

    private static void findFloor(TreeNode<Integer> root, int X) {
        if (root == null) {
            return;
        }

        if (root.data <= X) {
            predecessor = root.data;
            if (root.data == X) {
                return;
            }
            findFloor(root.right, X);
        } else {
            findFloor(root.left, X);
        }
    }

    public static int floorInBST(TreeNode<Integer> root, int X) {
        predecessor = 0;
        findFloor(root, X);
        return predecessor;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
