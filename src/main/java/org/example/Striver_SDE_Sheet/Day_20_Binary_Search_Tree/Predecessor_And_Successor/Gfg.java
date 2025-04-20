package org.example.Striver_SDE_Sheet.Day_20_Binary_Search_Tree.Predecessor_And_Successor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    static Node predecessor = null;
    static Node successor = null;

    private static void findPredecessor(Node root, int key) {
        if (root == null) {
            return;
        }

        if (root.data < key) {
            predecessor = root;
            findPredecessor(root.right, key);
        } else {
            findPredecessor(root.left, key);
        }
    }

    private static void findSuccessor(Node root, int key) {
        if (root == null) {
            return;
        }

        if (root.data > key) {
            successor = root;
            findSuccessor(root.left, key);
        } else {
            findSuccessor(root.right, key);
        }
    }

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        predecessor = null;
        successor = null;
        findPredecessor(root, key);
        findSuccessor(root, key);
        pre[0] = predecessor;
        suc[0] = successor;
    }
}

class Gfg {

    static Node buildTree(String str) {

        if (str.isEmpty() || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (!queue.isEmpty() && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine());
            Node[] pre = new Node[1];
            Node[] suc = new Node[1];
            Solution.findPreSuc(root, pre, suc, k);
            if (pre[0] != null) {
                System.out.print(pre[0].data + " ");
            } else {
                System.out.print("-1 ");
            }
            if (suc[0] != null) {
                System.out.println(suc[0].data);
            } else {
                System.out.println("-1 ");
            }
        }
    }
}