package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Top_View_Of_Binary_Tree;

import java.io.*;
import java.util.*;
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

class Helper {
    int height;
    int value;

    public Helper(int height, int value) {
        this.height = height;
        this.value = value;
    }
}

class Solution {

    static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countOfNodes(root.left) + countOfNodes(root.right);
    }

    static void topView(Node root, int currentHeight, int currentHorizontalDistance, Helper[] helpers, int countOfNodes) {
        if (root == null) {
            return;
        }

        if ((helpers[countOfNodes - currentHorizontalDistance].value == Integer.MIN_VALUE) || (helpers[countOfNodes - currentHorizontalDistance].height > currentHeight)) {
            helpers[countOfNodes - currentHorizontalDistance] = new Helper(currentHeight, root.data);
        }

        topView(root.left, currentHeight + 1, currentHorizontalDistance - 1, helpers, countOfNodes);
        topView(root.right, currentHeight + 1, currentHorizontalDistance + 1, helpers, countOfNodes);
    }

    static ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        int countOfNodes = countOfNodes(root);

        Helper[] helpers = new Helper[2 * countOfNodes + 1];

        for (int i = 0; i < (2 * countOfNodes + 1); i++) {
            helpers[i] = new Helper(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        topView(root, 0, 0, helpers, countOfNodes);

        for (int i = 0; i < (2 * countOfNodes + 1); i++) {
            if (helpers[i].value != Integer.MIN_VALUE) {
                list.add(helpers[i].value);
            }
        }

        return list;
    }
}


//class Helper {
//    int height;
//    int value;
//
//    public Helper(int height, int value) {
//        this.height = height;
//        this.value = value;
//    }
//}
//
//class Solution {
//
//    static void topView(Node root, int currentHeight, int currentHorizontalDistance, Map<Integer, Helper> horizontalDistanceToHelperMapping) {
//        if (root == null) {
//            return;
//        }
//
//        if (!horizontalDistanceToHelperMapping.containsKey(currentHorizontalDistance)) {
//            horizontalDistanceToHelperMapping.put(currentHorizontalDistance, new Helper(currentHeight, root.data));
//        } else if (horizontalDistanceToHelperMapping.get(currentHorizontalDistance).height > currentHeight) {
//            horizontalDistanceToHelperMapping.put(currentHorizontalDistance, new Helper(currentHeight, root.data));
//        }
//
//        topView(root.left, currentHeight + 1, currentHorizontalDistance - 1, horizontalDistanceToHelperMapping);
//        topView(root.right, currentHeight + 1, currentHorizontalDistance + 1, horizontalDistanceToHelperMapping);
//    }
//
//    static ArrayList<Integer> topView(Node root) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//
//        Map<Integer, Helper> horizontalDistanceToHelperMapping = new TreeMap<>();
//
//        topView(root, 0, 0, horizontalDistanceToHelperMapping);
//
//        for (Map.Entry<Integer, Helper> currentEntry : horizontalDistanceToHelperMapping.entrySet()) {
//            list.add(currentEntry.getValue().value);
//        }
//
//        return list;
//    }
//}

public class Tree {

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

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            ArrayList<Integer> vec = Solution.topView(root);
            for (int x : vec) System.out.print(x + " ");
            System.out.println();

            t--;
        }
    }
}