package org.example.Striver_SDE_Sheet.Day_14_Stack_And_Queue_Part_II._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int key;
    public int value;
    public Node previous;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> keyToValueMapping;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        keyToValueMapping = new HashMap<>();
        head = tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyToValueMapping.containsKey(key)) {
            Node currentNode = keyToValueMapping.get(key);
            pushCurrentNodeToLast(currentNode);
            return currentNode.value;
        } else {
            return -1;
        }
    }

    private void pushCurrentNodeToLast(Node currentNode) {
        if (head == tail || tail == currentNode) {
            // Single Element CDLL or currentNode is last Node
            return;
        }
        if (head == currentNode) {
            head = head.next;
            tail = tail.next;
        } else {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            tail.next = currentNode;
            currentNode.previous = tail;
            tail = tail.next;
            currentNode.next = head;
            head.previous = currentNode;
        }
    }

    public void put(int key, int value) {
        if (keyToValueMapping.containsKey(key)) {
            Node currentNode = keyToValueMapping.get(key);
            pushCurrentNodeToLast(currentNode);
            currentNode.value = value;
        } else {
            Node currentNode = new Node(key, value);
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                currentNode.previous = tail;
                tail = tail.next;
                if (keyToValueMapping.size() == capacity) {
                    keyToValueMapping.remove(head.key);
                    head = head.next;
                }
            }
            currentNode.next = head;
            head.previous = currentNode;
            keyToValueMapping.put(key, currentNode);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));

//        obj.put(2, 1);
//        obj.put(2, 2);
//        System.out.println(obj.get(2));
//        obj.put(1, 1);
//        obj.put(4, 1);
//        System.out.println(obj.get(2));
    }
}
