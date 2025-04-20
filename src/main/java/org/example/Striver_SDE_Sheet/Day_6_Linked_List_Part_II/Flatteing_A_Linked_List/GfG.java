package org.example.Striver_SDE_Sheet.Day_6_Linked_List_Part_II.Flatteing_A_Linked_List;

import java.util.Scanner;

// https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

class Flatttening_A_LinkedList {
    Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
        while (t > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }
}

public class GfG {

    private Node merge2NodesBottomNodesToFormSingleLLInBottomManner(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node finalHead = null;
        Node finalTail = null;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                if (finalHead == null) {
                    finalHead = a;
                    finalTail = a;
                } else {
                    finalTail.bottom = a;
                    finalTail = finalTail.bottom;
                }
                a = a.bottom;
            } else {
                if (finalHead == null) {
                    finalHead = b;
                    finalTail = b;
                } else {
                    finalTail.bottom = b;
                    finalTail = finalTail.bottom;
                }
                b = b.bottom;
            }
            finalTail.bottom = null;
        }

        if (a != null) {
            finalTail.bottom = a;
        }

        if (b != null) {
            finalTail.bottom = b;
        }

        return finalHead;
    }

    Node flatten(Node root) {

        if (root == null || root.next == null) {
            return root;
        }

        Node previousSortedLLTillNow = null;
        Node currentNode = root;
        while (currentNode != null) {
            previousSortedLLTillNow = merge2NodesBottomNodesToFormSingleLLInBottomManner(currentNode, previousSortedLLTillNow);
            currentNode = currentNode.next;
        }

        return previousSortedLLTillNow;
    }
}
