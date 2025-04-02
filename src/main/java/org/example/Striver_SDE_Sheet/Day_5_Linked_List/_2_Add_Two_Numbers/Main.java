package  org.example.Striver_SDE_Sheet.Day_5_Linked_List._2_Add_Two_Numbers;

// https://leetcode.com/problems/add-two-numbers/description/
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
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            result.append(current.val);
            current = current.next;
        }
        return result.toString();
    }
}

// 2 4 3
// 5 6 4

class Solution {
    // No Need to reverse LL. Just add from start as we add from last in addition only
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode resultHeadNode = null;
        ListNode resultTailNode = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int totalSum = l1.val + l2.val + carry;
            carry = totalSum / 10;
            totalSum %= 10;
            ListNode currentNode = new ListNode(totalSum, null);
            if (resultHeadNode == null) {
                resultHeadNode = currentNode;
                resultTailNode = currentNode;
            } else {
                resultTailNode.next = currentNode;
                resultTailNode = resultTailNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode currentNode = new ListNode(sum, null);
            // No need of check headNode==null because empty LL can be easily checked
            resultTailNode.next = currentNode;
            resultTailNode = currentNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode currentNode = new ListNode(sum, null);
            // No need of check headNode==null because empty LL can be easily checked
            resultTailNode.next = currentNode;
            resultTailNode = currentNode;
            l2 = l2.next;
        }

        if (carry == 1) {
            ListNode finalNode = new ListNode(carry);
            resultTailNode.next = finalNode;
            resultTailNode = finalNode;
        }

        return resultHeadNode;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode finalListNode = solution.addTwoNumbers(l1, l2);
        System.out.println(finalListNode);
    }
}
