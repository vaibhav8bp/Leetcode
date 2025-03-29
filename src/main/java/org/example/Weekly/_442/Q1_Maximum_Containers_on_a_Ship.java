package org.example.Weekly._442;

// https://leetcode.com/contest/weekly-contest-442/problems/maximum-containers-on-a-ship/description/
public class Q1_Maximum_Containers_on_a_Ship {
    public int maxContainers(int n, int w, int maxWeight) {
        int cells = n * n;
        return Math.min(cells, maxWeight / w);
    }
}
