package org.example.Striver_SDE_Sheet.Day_6_Linked_List_Part_II._141_Linked_List_Cycle;

// https://leetcode.com/problems/linked-list-cycle/description/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        } while (fast != null && fast.next != null);

        return false;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
