package org.example.Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/description/
public class _146_LRU_Cache {
}

class Node {
    int key;
    int value;
    Node next;
    Node previous;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Node headOfLL;
    Node tailOfLL;
    Map<Integer, Node> keyToNodeMapper;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.headOfLL = null;
        this.tailOfLL = null;
        this.keyToNodeMapper = new HashMap<>();
    }

    // If CurrentNode is Already Tail No Need to do anything.
    private void removeNodeAndMakeItTail(int key) {
        Node currentNode = keyToNodeMapper.get(key);

        if (currentNode != tailOfLL) {
            if (currentNode == headOfLL) {
                headOfLL = headOfLL.next;
                headOfLL.previous = null;
            } else {
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
            }
            tailOfLL.next = currentNode;
            currentNode.previous = tailOfLL;
            tailOfLL = tailOfLL.next;
        }
    }

    // Insert New Node To Tail Of LL
    private void insertNewNodeToTailOfLL(int key, int value) {
        Node newNode = new Node(key, value);

        if (headOfLL == null) {
            headOfLL = tailOfLL = newNode;
        } else {
            tailOfLL.next = newNode;
            newNode.previous = tailOfLL;
            tailOfLL = tailOfLL.next;
        }

        keyToNodeMapper.put(key, newNode);
    }

    private void removeHeadFromLL() {
        int key = headOfLL.key;
        keyToNodeMapper.remove(key);
        headOfLL = headOfLL.next;
        if (headOfLL != null) {
            headOfLL.previous = null;
        } else {
            tailOfLL = null;
        }
    }

    public int get(int key) {
        if (keyToNodeMapper.containsKey(key)) {
            int returnValue = keyToNodeMapper.get(key).value;
            removeNodeAndMakeItTail(key);
            return returnValue;
        }
        return -1;
    }

    public void put(int key, int value) {
        // Key Is Already Present In LL.
        if (keyToNodeMapper.containsKey(key)) {
            // Update its value.
            Node currentNode = keyToNodeMapper.get(key);
            currentNode.value = value;
            removeNodeAndMakeItTail(key);
        } else {
            // If Capacity reached, first remove head of LL.
            if (keyToNodeMapper.size() == capacity) {
                removeHeadFromLL();
            }
            // Add new Node to end of LL
            insertNewNodeToTailOfLL(key, value);
        }
    }
}