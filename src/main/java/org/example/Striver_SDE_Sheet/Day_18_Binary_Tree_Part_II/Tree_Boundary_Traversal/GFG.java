package org.example.Striver_SDE_Sheet.Day_18_Binary_Tree_Part_II.Tree_Boundary_Traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

    // Will fetch left and right extreme nodes
    // Will not fetch leaf nodes
    // If direction=true will fetch left extreme nodes
    // If direction=false will fetch right extreme nodes

    private void fetchExtremeNodes(Node node, boolean direction, ArrayList<Integer> list) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        // For direction=true fetch left else right
        list.add(node.data);
        if (direction) {
            if (node.left != null) {
                fetchExtremeNodes(node.left, true, list);
            }
            // Doing this because while traversing if left does not exist
            // going to right once and then again going left will also be boundary (left wasn't there so right became boundary)
            else {
                fetchExtremeNodes(node.right, true, list);
            }
        } else {
            if (node.right != null) {
                fetchExtremeNodes(node.right, false, list);
            } else {
                fetchExtremeNodes(node.left, false, list);
            }
        }
    }

    private void fetchLeafNodes(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.data);
            return;
        }

        fetchLeafNodes(node.left, list);
        fetchLeafNodes(node.right, list);
    }

    ArrayList<Integer> boundary(Node node) {
        // Order of return is Root+Left Extreme nodes+Leaf Nodes+Right Extreme Nodes(reversed)

        ArrayList<Integer> finalList = new ArrayList<>();

        if (node == null) {
            return finalList;
        }

        // Added Root
        finalList.add(node.data);

        if (node.left == null && node.right == null) {
            return finalList;
        }

        // Added Left Extreme Nodes
        fetchExtremeNodes(node.left, true, finalList);

        // Added Leaf Nodes
        fetchLeafNodes(node, finalList);

        // Add Right Extreme Nodes In Reverse Fashion

        ArrayList<Integer> rightList = new ArrayList<>();
        fetchExtremeNodes(node.right, false, rightList);
        Collections.reverse(rightList);
        finalList.addAll(rightList);

        return finalList;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.isEmpty())
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;
        }
    }
}

//1
//4 10 N 5 5 N 6 7 N 8 8 N 8 11 N 3 4 N 1 3 N 8 6 N 11 11 N 5 8