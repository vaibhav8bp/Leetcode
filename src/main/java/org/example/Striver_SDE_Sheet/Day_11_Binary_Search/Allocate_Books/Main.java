package org.example.Striver_SDE_Sheet.Day_11_Binary_Search.Allocate_Books;

import java.util.ArrayList;
import java.util.Comparator;

class Solution {

    private boolean canAllocate(int maxPages, ArrayList<Integer> books, int studentCount) {
        int currentStudentCount = 1;
        int currentStudentPagesCount = 0;

        for (Integer book : books) {
            if ((currentStudentPagesCount + book) > maxPages) {
                currentStudentCount++;
                currentStudentPagesCount = book;
            } else {
                currentStudentPagesCount += book;
            }
        }

        return (currentStudentCount <= studentCount);
    }

    public int books(ArrayList<Integer> A, int B) {
        if (A.size() < B) {
            return -1;
        }

        int low = A.stream().max(Comparator.naturalOrder()).get();
        int high = A.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAllocate(mid, A, B)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(100);
        list.add(11);
        System.out.println(new Solution().books(list, 4));
    }
}
