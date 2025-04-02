package org.example.Striver_SDE_Sheet.Day_5_Linked_List._876_Middle_Of_The_Linked_List;

// https://leetcode.com/problems/middle-of-the-linked-list/description/
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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            return slow.next;
        }

        return slow;
    }
}

public class Main {
}
