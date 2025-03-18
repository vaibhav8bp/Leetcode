package org.example.Striver_SDE_Sheet.Day_5_Linked_List._21_Merge_Two_Sorted_Lists;

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

    @Override
    public String toString() {
        ListNode listNode = this;
        StringBuilder temp = new StringBuilder();
        while (listNode != null) {
            temp.append(listNode.val).append(" ");
            listNode = listNode.next;
        }
        return temp.toString();
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode headOfMergedList = null;
        ListNode tailOfMergedList = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (headOfMergedList == null) {
                    headOfMergedList = new ListNode(list1.val, null);
                    tailOfMergedList = headOfMergedList;
                } else {
                    tailOfMergedList.next = new ListNode(list1.val, null);
                    tailOfMergedList = tailOfMergedList.next;
                }
                list1 = list1.next;
            } else {
                if (headOfMergedList == null) {
                    headOfMergedList = new ListNode(list2.val, null);
                    tailOfMergedList = headOfMergedList;
                } else {
                    tailOfMergedList.next = new ListNode(list2.val, null);
                    tailOfMergedList = tailOfMergedList.next;
                }
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            tailOfMergedList.next = new ListNode(list1.val, null);
            tailOfMergedList = tailOfMergedList.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            tailOfMergedList.next = new ListNode(list2.val, null);
            tailOfMergedList = tailOfMergedList.next;
            list2 = list2.next;
        }

        return headOfMergedList;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution a = new Solution();
        // 1 2 4
        // 1 3 4
        ListNode listNode1 = new ListNode(2, null);
        ListNode listNode2 = new ListNode(1, null);
        ListNode finalList = a.mergeTwoLists(listNode1, listNode2);
        System.out.println(finalList);
    }
}
