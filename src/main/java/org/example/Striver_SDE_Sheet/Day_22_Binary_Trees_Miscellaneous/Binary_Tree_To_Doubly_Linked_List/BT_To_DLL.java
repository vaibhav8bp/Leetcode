package org.example.Striver_SDE_Sheet.Day_22_Binary_Trees_Miscellaneous.Binary_Tree_To_Doubly_Linked_List;

import java.util.*;
import java.io.*;

class Node {
    Node left, right;
    int data;

    Node(int d) {
        data = d;
        left = right = null;
    }

}

class Solution {

    Node head = null;

    void bToDLLHelper(Node root) {
        if (root == null) {
            return;
        }

        bToDLLHelper(root.right);

        root.right = head;
        if (head != null) {
            head.left = root;
        }
        head = root;

        bToDLLHelper(root.left);
    }

    Node bToDLL(Node root) {
        bToDLLHelper(root);
        return head;
    }
}

// class Solution {
//    Node bToDLL(Node root) {
//        if (root == null) {
//            return null;
//        }

//        Node leftChain = bToDLL(root.left);
//        Node rightChain = bToDLL(root.right);
//        if (leftChain == null) {
//            leftChain = root;
//        } else {
//            Node temp = leftChain;
//            while (temp.right != null) {
//                temp = temp.right;
//            }
//            temp.right = root;
//            root.left = temp;
//        }

//        root.right = rightChain;

//        if (rightChain != null) {
//            rightChain.left = root;
//        }
//        return leftChain;
//    }
// }


public class BT_To_DLL {

    static Node buildTree(String str) throws IOException {

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

    public static void printList(Node head) {
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }

        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.left;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();

            Node ans = g.bToDLL(root);
            printList(ans);
            t--;
            System.out.println();
        }


    }
}