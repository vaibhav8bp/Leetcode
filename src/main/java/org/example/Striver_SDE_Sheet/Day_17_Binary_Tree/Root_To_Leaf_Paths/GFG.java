package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Root_To_Leaf_Paths;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.isEmpty() || str.charAt(0) == 'N')
            return null;

        // Creating array of Strings from input
        // String after splitting by space
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

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }
}


class IntMatrix {

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class Solution {

    private static void Paths(Node root, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        currentPath.add(root.data);

        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
            currentPath.removeLast();
            return;
        }

        Paths(root.left, currentPath, allPaths);
        Paths(root.right, currentPath, allPaths);
        currentPath.removeLast();
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        Paths(root, new ArrayList<>(), allPaths);
        return allPaths;
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node root = Node.inputTree(br);
            ArrayList<ArrayList<Integer>> res = Solution.Paths(root);

            IntMatrix.print(res);

        }
    }
}