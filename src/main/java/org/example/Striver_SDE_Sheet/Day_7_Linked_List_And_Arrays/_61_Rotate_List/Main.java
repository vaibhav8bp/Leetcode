package org.example.Striver_SDE_Sheet.Day_7_Linked_List_And_Arrays._61_Rotate_List;

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

// Expensive
// class ListNodePlusTailAndLength {
//    public ListNode head;
//    public ListNode tail;
//    public int length;

//    public ListNodePlusTailAndLength(ListNode head, ListNode tail, int length) {
//        this.head = head;
//        this.tail = tail;
//        this.length = length;
//    }
// }

// class Solution {

//    ListNode cloneList(ListNode head) {
//        ListNode temp = head;
//        ListNode clonedListHead = null;
//        ListNode clonedListTail = null;
//        while (temp != null) {
//            if (clonedListHead == null) {
//                clonedListHead = clonedListTail = new ListNode(temp.val, null);
//            } else {
//                clonedListTail.next = new ListNode(temp.val, null);
//                clonedListTail = clonedListTail.next;
//            }
//            temp = temp.next;
//        }
//        return clonedListHead;
//    }

//    ListNodePlusTailAndLength reverseLL(ListNode head) {

//        if (head == null) {
//            return new ListNodePlusTailAndLength(null, null, 0);
//        }
//        if (head.next == null) {
//            return new ListNodePlusTailAndLength(head, head, 1);
//        }

//        ListNode temp;
//        ListNode previous = null;
//        ListNode current = head;
//        int length = 0;

//        while (current != null) {
//            temp = current.next;
//            current.next = previous;
//            previous = current;
//            current = temp;
//            length++;
//        }

//        return new ListNodePlusTailAndLength(previous, head, length);
//    }

//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null || head.next == null || k == 0) {
//            return head;
//        }

//        // Clone LL in Case Of k=n*length
//        ListNode cloneList = cloneList(head);

//        // Reverse Entire LL
//        ListNodePlusTailAndLength reversedHead = reverseLL(head);
//        k = k % reversedHead.length;

//        if (k == 0) {
//            return cloneList;
//        }

//        ListNode currentNode = reversedHead.head;

//        for (int i = 0; i < k - 1; i++) {
//            currentNode = currentNode.next;
//        }

//        ListNode rightPartStart = currentNode.next;
//        // Ending First Part
//        currentNode.next = null;

//        // Reversing First Part Of Reversed LL
//        ListNodePlusTailAndLength firstPartOfReversedLLReversed = reverseLL(reversedHead.head);

//        // Reversing Second Part Of Reversed LL
//        ListNodePlusTailAndLength secondPartOfReversedLLReversed = reverseLL(rightPartStart);

//        firstPartOfReversedLLReversed.tail.next = secondPartOfReversedLLReversed.head;

//        return firstPartOfReversedLLReversed.head;
//    }
// }

// Optimal
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }


        ListNode temp = head;

        int count = 1;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        k %= count;

        if (k == 0) {
            return head;
        }

        // Making A Circular LL
        temp.next = head;

        temp = head;
        for (int i = 0; i < count - k - 1; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
