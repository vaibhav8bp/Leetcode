package org.example.Striver_SDE_Sheet.Day_6_Linked_List_Part_II._160_Intersection_Of_Two_Linked_Lists;

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {

    private int getLengthOfLinkedList(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthOfLLA = getLengthOfLinkedList(headA);
        int lengthOfLLB = getLengthOfLinkedList(headB);
        ListNode tempA = headA;
        ListNode tempB = headB;
        int differenceInLength = Math.abs(lengthOfLLA - lengthOfLLB);
        if (lengthOfLLA > lengthOfLLB) {
            while (differenceInLength != 0) {
                tempA = tempA.next;
                differenceInLength--;
            }
        } else if (lengthOfLLB > lengthOfLLA) {
            while (differenceInLength != 0) {
                tempB = tempB.next;
                differenceInLength--;
            }
        }

        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
