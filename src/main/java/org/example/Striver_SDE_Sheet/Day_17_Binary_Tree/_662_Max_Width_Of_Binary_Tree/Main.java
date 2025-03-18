package org.example.Striver_SDE_Sheet.Day_17_Binary_Tree._662_Max_Width_Of_Binary_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

class Helper {
    int index;
    TreeNode node;

    public Helper(int index, TreeNode node) {
        this.index = index;
        this.node = node;
    }
}

class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Helper> queue = new LinkedList<>();
        queue.add(new Helper(0, root));
        queue.add(null);
        int maxWidth = 1;
        int currentWidth = 0;
        int firstIndex = -1;
        while (!queue.isEmpty()) {
            Helper front = queue.remove();
            if (front != null) {
                if (front.node.left != null) {
                    queue.add(new Helper(2 * front.index + 1, front.node.left));
                }
                if (front.node.right != null) {
                    queue.add(new Helper(2 * front.index + 2, front.node.right));
                }
                if (firstIndex == -1) {
                    firstIndex = front.index;
                    currentWidth = 1;
                } else {
                    currentWidth = front.index - firstIndex + 1;
                }
            } else {
                // One Level Is Cleared calculate Width Of Current Level and move to next
                maxWidth = Math.max(maxWidth, currentWidth);
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                firstIndex = -1;
                currentWidth = 0;
            }
        }

        return maxWidth;
    }
}

//class Solution {
//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int currentLevelMaximumNodes = 1;
//        int maxWidth = 0;
//        while (!queue.isEmpty()) {
//            // To specify current level width
//            int start = -1;
//            int end = -1;
//            int widthFromStart = 0;
//            for (int i = 1; i <= currentLevelMaximumNodes; i++) {
//                TreeNode front = queue.remove();
//                if (front != null) {
//                    if (start == -1) {
//                        start = end = 1;
//                        widthFromStart = 0;
//                    } else {
//                        end = start + widthFromStart;
//                    }
//
//                    if (front.left != null) {
//                        queue.add(front.left);
//                    } else {
//                        queue.add(null);
//                    }
//                    if (front.right != null) {
//                        queue.add(front.right);
//                    } else {
//                        queue.add(null);
//                    }
//                } else {
//                    queue.add(null);
//                    queue.add(null);
//                }
//                widthFromStart++;
//            }
//
//            if (end == -1) {
//                break;
//            }
//
//            maxWidth = Math.max(maxWidth, end);
//            currentLevelMaximumNodes *= 2;
//        }
//
//        return maxWidth;
//    }
//}


public class Main {
    public static void main(String[] args) {

    }
}
