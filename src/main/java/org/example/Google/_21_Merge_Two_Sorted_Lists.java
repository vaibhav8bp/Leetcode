package org.example.Google;

// https://leetcode.com/problems/merge-two-sorted-lists/

public class _21_Merge_Two_Sorted_Lists {

    static class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode answerHead = null;
        ListNode answerTail = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (answerHead == null) {
                    answerHead = answerTail = list1;
                } else {
                    answerTail.next = list1;
                    answerTail = answerTail.next;
                }
                list1 = list1.next;
            } else {
                if (answerHead == null) {
                    answerHead = answerTail = list2;
                } else {
                    answerTail.next = list2;
                    answerTail = answerTail.next;
                }
                list2 = list2.next;
            }
            answerTail.next = null;
        }

        if (list1 != null) {
            answerTail.next = list1;
        }
        else {
            answerTail.next = list2;
        }

        return answerHead;
    }
}
