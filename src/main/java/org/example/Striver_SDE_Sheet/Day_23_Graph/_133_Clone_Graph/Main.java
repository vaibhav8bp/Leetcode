package org.example.Striver_SDE_Sheet.Day_23_Graph._133_Clone_Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {

    private void populateMapping(Node currentNode, Map<Integer, Node> valueToNodeMapping) {

        Node currentNewNode = null;

        if (valueToNodeMapping.containsKey(currentNode.val)) {
            currentNewNode = valueToNodeMapping.get(currentNode.val);
        } else {
            currentNewNode = new Node(currentNode.val);
            valueToNodeMapping.put(currentNode.val, currentNewNode);
        }

        // Population
        for (int i = 0; i < currentNode.neighbors.size(); i++) {
            Node currentNeighbor = currentNode.neighbors.get(i);

            Node currentNeighBorNewNode = null;
            if (!valueToNodeMapping.containsKey(currentNeighbor.val)) {
                currentNeighBorNewNode = new Node(currentNeighbor.val);
                valueToNodeMapping.put(currentNeighbor.val, currentNeighBorNewNode);
            } else {
                currentNeighBorNewNode = valueToNodeMapping.get(currentNeighbor.val);
            }

            currentNewNode.neighbors.add(currentNeighBorNewNode);
        }

        // DFS
        for (int i = 0; i < currentNode.neighbors.size(); i++) {
            Node currentNeighbor = currentNode.neighbors.get(i);

            // Only call recursion if new node neighbor does not have neighbors and old neighbor have neighbor's
            if (valueToNodeMapping.get(currentNeighbor.val).neighbors.isEmpty() && !currentNeighbor.neighbors.isEmpty()) {
                populateMapping(currentNeighbor, valueToNodeMapping);
            }
        }
    }


    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Integer, Node> valueToNodeMapping = new HashMap<>();
        populateMapping(node, valueToNodeMapping);
        return valueToNodeMapping.get(node.val);
    }
}

public class Main {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors.add(one);
        two.neighbors.add(three);

        three.neighbors.add(two);
        three.neighbors.add(four);

        four.neighbors.add(one);
        four.neighbors.add(three);

        System.out.println(new Solution().cloneGraph(one));
    }
}
