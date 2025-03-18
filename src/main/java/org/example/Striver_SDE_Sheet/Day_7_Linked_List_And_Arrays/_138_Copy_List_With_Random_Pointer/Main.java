package org.example.Striver_SDE_Sheet.Day_7_Linked_List_And_Arrays._138_Copy_List_With_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        Node currentNode = head;
        Node newHead = null;
        Node newTail = null;

        Map<Node, Integer> nodeToIndexMappingForOriginalList = new HashMap<>();
        Map<Integer, Node> indexToNodeMappingForNewList = new HashMap<>();

        int index = 0;
        while (currentNode != null) {
            if (newHead == null) {
                newHead = new Node(currentNode.val);
                newTail = newHead;
            } else {
                newTail.next = new Node(currentNode.val);
                newTail = newTail.next;
            }
            nodeToIndexMappingForOriginalList.put(currentNode, index);
            indexToNodeMappingForNewList.put(index, newTail);
            currentNode = currentNode.next;
            index++;
        }

        currentNode = head;
        Node tempNode = newHead;
        while (currentNode != null) {
            if (currentNode.random != null) {
                tempNode.random = indexToNodeMappingForNewList.get(nodeToIndexMappingForOriginalList.get(currentNode.random));
            }
            currentNode = currentNode.next;
            tempNode = tempNode.next;
        }

        return newHead;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

