package org.example.Striver_SDE_Sheet.Day_5_Linked_List._237_Delete_Node_In_A_Linked_List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode previous = null;
        while (temp.next != null) {
            previous = temp;
            temp.val = temp.next.val;
            temp = temp.next;
        }
        previous.next = null;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}