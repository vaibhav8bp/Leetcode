package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree.Bottom_View_Of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    int hd;
    Node left, right;

    // Constructor of tree node
    public Node(int key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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

    private int countOfNodesInTree(Node root) {
        if (root == null) {
            return 0;
        }

        int left = countOfNodesInTree(root.left);
        int right = countOfNodesInTree(root.right);

        return 1 + left + right;
    }

    private void bottomView(Node root, int currentHeight, int currentHorizontalDistance, Helper[] helper, int countOfNodes) {
        if (root == null) {
            return;
        }

        // No node present for current horizontal distance or greater than equal to height present
        if ((helper[currentHorizontalDistance + countOfNodes].value == Integer.MIN_VALUE) ||
                (helper[currentHorizontalDistance + countOfNodes].height <= currentHeight)) {
            helper[currentHorizontalDistance + countOfNodes].height = currentHeight;
            helper[currentHorizontalDistance + countOfNodes].value = root.data;
        }

        bottomView(root.left, currentHeight + 1, currentHorizontalDistance - 1, helper, countOfNodes);
        bottomView(root.right, currentHeight + 1, currentHorizontalDistance + 1, helper, countOfNodes);
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int countOfNodes = countOfNodesInTree(root);
        // index will denote the horizontal distance
        Helper[] helper = new Helper[2 * countOfNodes + 1];
        for (int i = 0; i < (2 * countOfNodes + 1); i++) {
            helper[i] = new Helper(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        bottomView(root, 0, 0, helper, countOfNodes);

        for (int i = 0; i < (2 * countOfNodes + 1); i++) {
            if (helper[i].value != Integer.MIN_VALUE) {
                list.add(helper[i].value);
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
//    private void bottomView(Node root, int currentHorizontalDistance, int currentHeight, Map<Integer, Helper> horizontalDistanceToNodeMapping) {
//        if (root == null) {
//            return;
//        }
//
//        if (!horizontalDistanceToNodeMapping.containsKey(currentHorizontalDistance)) {
//            horizontalDistanceToNodeMapping.put(currentHorizontalDistance, new Helper(currentHeight, root.data));
//        } else {
//            int existingHeight = horizontalDistanceToNodeMapping.get(currentHorizontalDistance).height;
//            // Using = to get right most value
//            if (currentHeight >= existingHeight) {
//                horizontalDistanceToNodeMapping.put(currentHorizontalDistance, new Helper(currentHeight, root.data));
//            }
//        }
//
//        bottomView(root.left, currentHorizontalDistance - 1, currentHeight + 1,horizontalDistanceToNodeMapping);
//        bottomView(root.right, currentHorizontalDistance + 1, currentHeight + 1, horizontalDistanceToNodeMapping);
//    }
//
//    public ArrayList<Integer> bottomView(Node root) {
//        Map<Integer, Helper> horizontalDistanceToNodeMapping = new TreeMap<>();
//        bottomView(root, 0, 0, horizontalDistanceToNodeMapping);
//        ArrayList<Integer> list = new ArrayList<>();
//        for (Map.Entry<Integer, Helper> currentEntry : horizontalDistanceToNodeMapping.entrySet()) {
//            list.add(currentEntry.getValue().value);
//        }
//        return list;
//    }
//}


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
            Solution ob = new Solution();
            ArrayList<Integer> res = ob.bottomView(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
        }
    }
}