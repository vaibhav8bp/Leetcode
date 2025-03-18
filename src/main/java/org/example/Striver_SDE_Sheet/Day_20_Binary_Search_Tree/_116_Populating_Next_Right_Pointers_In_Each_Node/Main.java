package org.example.Striver_SDE_Sheet.Day_20_Binary_Search_Tree._116_Populating_Next_Right_Pointers_In_Each_Node;


import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node previous = null;
            for (int i = 0; i < size; i++) {

                Node front = queue.remove();

                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }

                if (previous != null) {
                    previous.next = front;
                }
                previous = front;
            }
        }

        return root;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}