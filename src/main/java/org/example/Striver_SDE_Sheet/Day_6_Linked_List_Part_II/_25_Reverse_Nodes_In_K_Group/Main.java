package org.example.Striver_SDE_Sheet.Day_6_Linked_List_Part_II._25_Reverse_Nodes_In_K_Group;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Recursive
class Solution_R {
    private int lengthOfLL(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private ListNode reverseLLAndConnectToNextNode(ListNode head, int k) {
        ListNode temp = head;
        ListNode previous = null;
        ListNode current = head;
        while (k != 0) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            k--;
        }
        head.next = temp;
        return previous;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1) {
            return head;
        }

        int length = lengthOfLL(head);
        ListNode finalHead = null;
        ListNode currentNode = head;
        ListNode previousIterationLastNode = null;
        while (length >= k) {
            ListNode temp = reverseLLAndConnectToNextNode(currentNode, k);
            if (finalHead == null) {
                finalHead = temp;
            } else {
                previousIterationLastNode.next = temp;
            }
            previousIterationLastNode = currentNode;
            currentNode = currentNode.next;
            length -= k;
        }
        return finalHead;
    }
}

// Iterative
class Solution {
    private int lengthOfLL(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k == 0 || k == 1) {
            return head;
        }

        int originalK = k;
        int length = lengthOfLL(head);
        ListNode currentHead = head;
        ListNode finalHead = null;
        ListNode previousIterationLastNode = null;

        while (length >= originalK) {
            k = originalK;
            ListNode temp;
            ListNode previous = null;
            ListNode current = currentHead;
            while (k != 0) {
                temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
                k--;
            }
            if (finalHead == null) {
                finalHead = previous;
            } else {
                // Connecting current list to previous list
                previousIterationLastNode.next = previous;
            }
            previousIterationLastNode = currentHead;
            // Connecting current list to next list
            currentHead.next = current;
            currentHead = currentHead.next;
            length -= originalK;
        }

        return finalHead;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
