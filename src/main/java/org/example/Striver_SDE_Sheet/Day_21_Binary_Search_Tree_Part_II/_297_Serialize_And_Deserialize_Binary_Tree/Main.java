package org.example.Striver_SDE_Sheet.Day_21_Binary_Search_Tree_Part_II._297_Serialize_And_Deserialize_Binary_Tree;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder string = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode front = queue.remove();
            if (front == null) {
                string.append("N,");
            } else {
                string.append(front.val).append(",");
                queue.add(front.left);
                queue.add(front.right);
            }
        }
        return string.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.isEmpty()) {
            return null;
        }

        String[] list = data.split(",");
        // Now just make tree from list

        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // At ant point ith element is the Left Child Of Queue's Front and so on
        for (int i = 1; i < list.length; i += 2) {
            TreeNode front = queue.remove();
            if (!list[i].equals("N")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(list[i]));
                front.left = leftChild;
                queue.add(leftChild);
            }
            if (!list[i + 1].equals("N")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(list[i + 1]));
                front.right = rightChild;
                queue.add(rightChild);
            }
        }

        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(null));
    }
}