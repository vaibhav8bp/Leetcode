package org.example.Google;

// https://leetcode.com/problems/add-two-numbers/

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

public class _2_Add_Two_Numbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerHead = null;
        ListNode answerTail = null;
        int carryForward = 0;

        while (l1 != null && l2 != null) {
            int currentSum = l1.val + l2.val + carryForward;
            if (currentSum >= 10) {
                carryForward = 1;
                currentSum -= 10;
            } else {
                carryForward = 0;
            }
            if (answerHead == null) {
                answerHead = answerTail = new ListNode(currentSum);
            } else {
                answerTail.next = new ListNode(currentSum);
                answerTail = answerTail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int currentSum = l1.val + carryForward;
            if (currentSum >= 10) {
                carryForward = 1;
                currentSum -= 10;
            } else {
                carryForward = 0;
            }
            if (answerHead == null) {
                answerHead = answerTail = new ListNode(currentSum);
            } else {
                answerTail.next = new ListNode(currentSum);
                answerTail = answerTail.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int currentSum = l2.val + carryForward;
            if (currentSum >= 10) {
                carryForward = 1;
                currentSum -= 10;
            } else {
                carryForward = 0;
            }
            if (answerHead == null) {
                answerHead = answerTail = new ListNode(currentSum);
            } else {
                answerTail.next = new ListNode(currentSum);
                answerTail = answerTail.next;
            }
            l2 = l2.next;
        }

        if (carryForward == 1) {
            answerTail.next = new ListNode(1);
        }

        return answerHead;
    }

    public static void main(String[] args) {
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);

        two.next = four;
        four.next = three;

        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode fourA = new ListNode(4);

        five.next = six;
        six.next = fourA;

        System.out.println(addTwoNumbers(two, five));
    }
}
