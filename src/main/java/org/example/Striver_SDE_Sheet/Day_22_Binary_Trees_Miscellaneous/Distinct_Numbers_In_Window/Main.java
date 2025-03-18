package org.example.Striver_SDE_Sheet.Day_22_Binary_Trees_Miscellaneous.Distinct_Numbers_In_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private void addNumberToHashMap(int currentNumber, Map<Integer, Integer> numberToFrequencyMapping) {
        if (!numberToFrequencyMapping.containsKey(currentNumber)) {
            numberToFrequencyMapping.put(currentNumber, 1);
        } else {
            numberToFrequencyMapping.put(currentNumber, numberToFrequencyMapping.get(currentNumber) + 1);
        }
    }

    private void removeNumberFromHashMap(int currentNumber, Map<Integer, Integer> numberToFrequencyMapping) {
        numberToFrequencyMapping.put(currentNumber, numberToFrequencyMapping.get(currentNumber) - 1);
        if (numberToFrequencyMapping.get(currentNumber) == 0) {
            numberToFrequencyMapping.remove(currentNumber);
        }
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A.size() < B || (B == 0)) {
            return list;
        }

        Map<Integer, Integer> numberToFrequencyMapping = new HashMap<>();

        for (int i = 0; i < B; i++) {
            addNumberToHashMap(A.get(i), numberToFrequencyMapping);
        }

        for (int i = B; i < A.size(); i++) {
            removeNumberFromHashMap(A.get(i - B), numberToFrequencyMapping);
            addNumberToHashMap(A.get(i), numberToFrequencyMapping);
            list.add(numberToFrequencyMapping.size());
        }

        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 1, 3, 4, 3));
        System.out.println(new Solution().dNums(list, 3));
    }
}