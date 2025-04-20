package org.example.Striver_SDE_Sheet.Day_8_Greedy_Algorithm.Fractional_Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }
}

class Solution {
    double fractionalKnapsack(int w, Item[] arr, int n) {
        Comparator<Item> valueByWeightComparator = (a, b) -> {
            double valueByWeightForA = ((double) a.value / a.weight);
            double valueByWeightForB = ((double) b.value / b.weight);

            // Primary comparison: descending order of value/weight
            int comparison = Double.compare(valueByWeightForB, valueByWeightForA);
            if (comparison == 0) {
                // Secondary comparison: descending order of value
                comparison = Integer.compare(b.value, a.value);
            }
            return comparison;
        };

        Arrays.sort(arr, valueByWeightComparator);

        double maxValue = 0;

        for (int i = 0; i < n && w != 0; i++) {
            if (arr[i].weight <= w) {
                // Complete
                maxValue += arr[i].value;
                w -= arr[i].weight;
            } else {
                // Fractional
                double currentIterationValue = (((double) w * arr[i].value) / arr[i].weight);
                maxValue += currentIterationValue;
                w = 0;
            }
        }

        return maxValue;
    }
}

public class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                        Integer.parseInt(inputLine[k++]));
            }
            System.out.printf("%.6f%n", new Solution().fractionalKnapsack(w, arr, n));
        }
    }
}

//Input:
//n = 3
//w = 50
//value[] = {60,100,120}
//weight[] = {10,20,30}
//Output:
//        240.000000
//Explanation:
//Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0
//Thus, total maximum value of item we can have is 240.00 from the given capacity of sack.

//1
//3 50
//60 10 100 20 120 30

//Input:
//n = 2
//w = 50
//value[] = {60,100}
//weight[] = {10,20}
//Output:
//        160.000000
//Explanation:
//Take both the items completely, without breaking.
//Total maximum value of item we can have is 160.00 from the given capacity of sack.

//1
//2 50
//60 10 100 20

//1
//10 21
//8 10 2 1 10 7 1 7 9 5 7 1 2 8 6 6 4 8 9 7