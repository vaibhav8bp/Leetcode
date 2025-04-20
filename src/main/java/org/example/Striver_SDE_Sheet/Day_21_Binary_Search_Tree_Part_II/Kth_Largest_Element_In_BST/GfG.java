package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II.Kth_Largest_Element_In_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
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

    private int countOfTotalNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countOfTotalNodes(root.left) + countOfTotalNodes(root.right);
    }

    int count = 0;
    int answer = 0;

    private void kthSmallest(Node root, int K) {
        if (root == null) {
            return;
        }

        kthSmallest(root.left, K);
        count++;
        if (count == K) {
            answer = root.data;
            return;
        }
        kthSmallest(root.right, K);
    }

    public int kthLargest(Node root, int K) {
        int total = countOfTotalNodes(root);
        int smallestPosition = total - K + 1;
        kthSmallest(root,smallestPosition);
        return answer;
    }
}

public class GfG {

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
            if (i >= ip.length)
                break;

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

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine());

            Solution g = new Solution();
            System.out.println(g.kthLargest(root, k));
            t--;
        }
    }
}