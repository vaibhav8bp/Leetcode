package org.example.Striver_SDE_Sheet.Day_18_Binary_Tree_Part_II.Level_order_traversal_in_spiral_form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

class Spiral {
    ArrayList<Integer> findSpiral(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 0;

        ArrayList<Integer> finalList = new ArrayList<>();

        ArrayList<Integer> currentLevelList = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node front = queue.remove();
            if (front != null) {
                currentLevelList.add(front.data);
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            } else {
                // For even level traverse right to left
                // For odd level traverse left to right

                if (level % 2 == 0) {
                    Collections.reverse(currentLevelList);
                }

                finalList.addAll(currentLevelList);

                if (queue.isEmpty()) {
                    break;
                }
                currentLevelList = new ArrayList<>();
                level++;
                queue.add(null);
            }

        }

        return finalList;
    }
}

class GfG {

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

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Spiral g = new Spiral();
            ArrayList<Integer> result = g.findSpiral(root);
            for (int value : result)
                System.out.print(value + " ");
            System.out.println();
        }
    }
}