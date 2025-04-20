package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Left_View_Of_Binary_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
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

// Recursive Solution
// class Tree {

//     // maxheight needs to be global because we are increasing height while traversing in DFS manner
//     int maxHeight = 0;

//     void leftView(Node root, ArrayList<Integer> currentList, int height) {
//         if (root == null) {
//             return;
//         }

//         //If height and maxHeight matches take this node as it is coming for the first time
//         if (height == maxHeight) {
//             currentList.add(root.data);
//             maxHeight++;
//         }

//         leftView(root.left, currentList, height + 1);
//         leftView(root.right, currentList, height + 1);
//     }

//     ArrayList<Integer> leftView(Node root) {
//         ArrayList<Integer> list = new ArrayList<>();
//         leftView(root, list, 0);
//         return list;
//     }
// }

// Queue Solution
class Tree {
   ArrayList<Integer> leftView(Node root) {
       ArrayList<Integer> list = new ArrayList<>();

       if (root == null) {
           return list;
       }

       list.add(root.data);

       Queue<Node> queue = new ArrayDeque<>();
       queue.add(root);
       // Indicator when one level is traversed
       queue.add(new Node(-1));

       while (!queue.isEmpty()) {
           Node front = queue.remove();
           if (front.data == -1) {
               // One Level is Passed insert null again
               if (!queue.isEmpty()) {
                   list.add(queue.element().data);
                   queue.add(new Node(-1));
               } else {
                   break;
               }
           } else {
               if (front.left != null) {
                   queue.add(front.left);
               }
               if (front.right != null) {
                   queue.add(front.right);
               }
           }
       }
       return list;
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

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> result = g.leftView(root);
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
            t--;
        }
    }
}