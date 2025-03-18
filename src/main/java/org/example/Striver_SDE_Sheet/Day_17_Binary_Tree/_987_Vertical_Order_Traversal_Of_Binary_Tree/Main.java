package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree._987_Vertical_Order_Traversal_Of_Binary_Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Helper1 {
    List<Integer> values;

    public Helper1() {
        this.values = new ArrayList<>();
    }
}

class Helper {
    Helper1[] values;

    public Helper(Helper1[] values) {
        this.values = values;
    }
}

class Helper2 {
    int height;
    int totalNodes;

    public Helper2(int height, int totalNodes) {
        this.height = height;
        this.totalNodes = totalNodes;
    }
}

class Solution {

    private Helper2 countOfNodesAndHeightOfTree(TreeNode root) {
        if (root == null) {
            return new Helper2(0, 0);
        }

        Helper2 left = countOfNodesAndHeightOfTree(root.left);
        Helper2 right = countOfNodesAndHeightOfTree(root.right);

        return new Helper2(1 + Math.max(left.height, right.height), 1 + left.totalNodes + right.totalNodes);
    }

    private void verticalTraversal(TreeNode root, int currentHeight, int currentHorizontalDistance, Helper[] helpers, int countOfNodes) {
        if (root == null) {
            return;
        }

        helpers[currentHorizontalDistance + countOfNodes].values[currentHeight].values.add(root.val);

        verticalTraversal(root.left, currentHeight + 1, currentHorizontalDistance - 1, helpers, countOfNodes);
        verticalTraversal(root.right, currentHeight + 1, currentHorizontalDistance + 1, helpers, countOfNodes);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Helper2 helper2 = countOfNodesAndHeightOfTree(root);

        int countOfNodes = helper2.totalNodes;
        int heightOfTree = helper2.height;

        Helper[] helpers = new Helper[2 * countOfNodes + 1];

        for (int i = 0; i < (2 * countOfNodes + 1); i++) {
            Helper1[] helper1s = new Helper1[heightOfTree];
            for (int j = 0; j < heightOfTree; j++) {
                helper1s[j] = new Helper1();
            }
            helpers[i] = new Helper(helper1s);
        }

        verticalTraversal(root, 0, 0, helpers, countOfNodes);

        List<List<Integer>> finalList = new ArrayList<>();

        for (int i = 0; i < (2 * countOfNodes + 1); i++) {
            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j < helpers[i].values.length; j++) {
                if (helpers[i].values[j].values.isEmpty()) {
                    continue;
                }
                helpers[i].values[j].values.sort(Comparator.naturalOrder());
                currentList.addAll(helpers[i].values[j].values);
            }
            if (!currentList.isEmpty()) {
                finalList.add(currentList);
            }
        }

        return finalList;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}