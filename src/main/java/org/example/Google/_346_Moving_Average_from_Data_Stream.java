package org.example.Google;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/moving-average-from-data-stream/description/
public class _346_Moving_Average_from_Data_Stream {
}

class MovingAverage {

    Deque<Integer> deque;
    int size;
    int sum;

    public MovingAverage(int size) {
        this.deque = new ArrayDeque<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        sum += val;
        deque.add(val);
        if (deque.size() == size + 1) {
            sum -= deque.pollFirst();
        }
        return (double) sum / deque.size();
    }
}
