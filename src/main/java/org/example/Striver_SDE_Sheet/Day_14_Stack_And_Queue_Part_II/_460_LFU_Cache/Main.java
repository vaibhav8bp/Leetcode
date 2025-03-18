package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._460_LFU_Cache;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    int frequency;
    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        frequency = 1;
        this.previous = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void deleteNodeFromLL(Node currentNode) {
        // Only 1 Node in DLL
        if (head == tail) {
            if (currentNode == head) {
                head = tail = null;
            } else {
                return;
            }
        }
        // Head To Be Deleted
        if (head == currentNode) {
            tail.next = head.next;
            head.next.previous = tail;
            head = head.next;
        }
        // Tail To Be Deleted
        else if (tail == currentNode) {
            tail.previous.next = head;
            head.previous = tail.previous;
            tail = tail.previous;
        } else {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
    }

    void addNodeToLast(Node currentNode) {
        if (head == null) {
            head = currentNode;
            tail = currentNode;
        } else {
            tail.next = currentNode;
            currentNode.previous = tail;
            tail = tail.next;
        }
        tail.next = head;
        head.previous = tail;
    }
}

class LFUCache {

    // This map is maintaining frequency as key and value is the Circular Doubly Linked List.
    // CDLL is maintained in order to implement LRU. And have taken map to achieve O(1) complexity.
    Map<Integer, DoublyLinkedList> frequencyToLRUNodeMapping;

    // To Access Any Node's Position in O(1)
    Map<Integer, Node> keyToNodeMapping;

    // To get minimum frequency in O(1)
    int minimumFrequency = 0;

    int capacity;

    public LFUCache(int capacity) {
        frequencyToLRUNodeMapping = new HashMap<>();
        keyToNodeMapping = new HashMap<>();
        this.capacity = capacity;
    }

    private int increaseFrequencyAndAdjust(int key, Integer value) {
        int currentFrequency = keyToNodeMapping.get(key).frequency;
        // Remove from frequencyToLRUNodeMapping for currentFrequency
        DoublyLinkedList currentFrequencyDLL = frequencyToLRUNodeMapping.get(currentFrequency);
        Node currentNode = keyToNodeMapping.get(key);
        int currentNodeValue = currentNode.value;
        currentFrequencyDLL.deleteNodeFromLL(currentNode);

        // Check if currentFrequency DLL is finished
        if (currentFrequencyDLL.head == null) {
            frequencyToLRUNodeMapping.remove(currentFrequency);
            currentNode = new Node(key, currentNodeValue);
            if (this.minimumFrequency == currentFrequency) {
                this.minimumFrequency++;
            }
        }

        // Add to frequencyToLRUNodeMapping for currentFrequency+1
        if (!frequencyToLRUNodeMapping.containsKey(currentFrequency + 1)) {
            frequencyToLRUNodeMapping.put(currentFrequency + 1, new DoublyLinkedList());
        }

        DoublyLinkedList currentFrequencyPlusOneDLL = frequencyToLRUNodeMapping.get(currentFrequency + 1);
        currentFrequencyPlusOneDLL.addNodeToLast(currentNode);

        // Update key's values' node in keyToNodeMapping

        // Increase Frequency of currentNode
        currentNode.frequency = currentFrequency + 1;

        if (value != null) {
            currentNode.value = value;
        }

        keyToNodeMapping.put(key, currentNode);
        return currentNode.value;
    }

    public int get(int key) {
        if (keyToNodeMapping.containsKey(key)) {
            return increaseFrequencyAndAdjust(key, null);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keyToNodeMapping.containsKey(key)) {
            increaseFrequencyAndAdjust(key, value);
        } else {
            Node newNode = new Node(key, value);
            if (keyToNodeMapping.size() == capacity) {
                int keyToBeDeleted = frequencyToLRUNodeMapping.get(minimumFrequency).head.key;
                DoublyLinkedList minimumFrequencyDLL = frequencyToLRUNodeMapping.get(minimumFrequency);
                if (minimumFrequencyDLL.head == minimumFrequencyDLL.tail) {
                    frequencyToLRUNodeMapping.remove(minimumFrequency);
                } else {
                    minimumFrequencyDLL.deleteNodeFromLL(minimumFrequencyDLL.head);
                }
                keyToNodeMapping.remove(keyToBeDeleted);
            }
            if (!frequencyToLRUNodeMapping.containsKey(1)) {
                frequencyToLRUNodeMapping.put(1, new DoublyLinkedList());
            }
            DoublyLinkedList singleFrequencyDLL = frequencyToLRUNodeMapping.get(1);
            singleFrequencyDLL.addNodeToLast(newNode);
            keyToNodeMapping.put(key, newNode);
            this.minimumFrequency = 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LFUCache obj = new LFUCache(2);
        obj.put(2, 1);
        obj.put(2, 2);
        System.out.println(obj.get(2));
        obj.put(1, 1);
        obj.put(4, 1);
        System.out.println(obj.get(2));
    }
}