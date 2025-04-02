package org.example.Striver_SDE_Sheet.Day_5_Linked_List._18_Remove_Nth_Node_From_End_Of_List;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        // No Deletion
        if (length < n) {
            return head;
        }

        int elementTOBeDeletedIndex = length - n;
        if (elementTOBeDeletedIndex == 0) {
            return head.next;
        } else {
            ListNode previousNode = null;
            temp = head;
            while (elementTOBeDeletedIndex != 0) {
                previousNode = temp;
                temp = temp.next;
                elementTOBeDeletedIndex--;
            }
            previousNode.next = temp.next;
            return head;
        }
    }
}

public class Main {
}
