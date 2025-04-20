package org.example.Striver_SDE_Sheet.Day_6_Linked_List_Part_II._234_Palindrome_Linked_List;

// https://leetcode.com/problems/palindrome-linked-list/description/
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

    private ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedHeadOfRightPart = reverseLL(slow.next);
        slow.next = null;

        while (reversedHeadOfRightPart != null) {
            if (head.val != reversedHeadOfRightPart.val) {
                return false;
            }
            head = head.next;
            reversedHeadOfRightPart = reversedHeadOfRightPart.next;
        }
        return true;

    }
}

public class Main {
    public static void main(String[] args) {

    }
}
