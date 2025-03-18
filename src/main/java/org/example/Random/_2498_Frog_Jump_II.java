package org.example.Random;

// https://leetcode.com/problems/frog-jump-ii/description/
public class _2498_Frog_Jump_II {

    // Try to think

    // a1 a2 a3 a4 a5 a6 a7
    // We have to minimize a3-a1,a4-a2
    // So what ever is the max of i and i-2 elements that will be our answer.
    // Check for corner case of length=2

    public static int maxJump(int[] stones) {
        // Corner Case For 2 length
        int minJump = stones[1] - stones[0];

        for (int i = 2; i < stones.length; i++) {
            // IMP: have to take max here as we have already taken care of minimize logic.
            minJump = Math.max(minJump, stones[i] - stones[i - 2]);
        }

        return minJump;
    }

//    private static boolean isPossibleToTravelInMaxCurrentJump(int maxJumpAllowed, int[] stones) {
//
//        // Forward Traversal
//        boolean[] visited = new boolean[stones.length];
//        int index = 0;
//
//        while (index < stones.length) {
//            // Jump to max possible
//            int nextIndex = index + 1;
//
//            while (nextIndex < stones.length && Math.abs(stones[nextIndex] - stones[index]) <= maxJumpAllowed) {
//                nextIndex++;
//            }
//
//            if (nextIndex == stones.length) {
//                break;
//            }
//
//            int lastPossibleIndex = nextIndex - 1;
//
//            if (lastPossibleIndex == index) {
//                return false;
//            } else {
//                index = lastPossibleIndex;
//                visited[index] = true;
//            }
//        }
//
//        // Backward Traversal
//
//        index = stones.length - 1;
//
//        while (index >= 0) {
//            int previousIndex = index - 1;
//
//            int lastPossibleIndex = index;
//
//            while (previousIndex >= 0 && Math.abs(stones[previousIndex] - stones[index]) <= maxJumpAllowed) {
//                if (!visited[previousIndex]) {
//                    lastPossibleIndex = previousIndex;
//                }
//                previousIndex--;
//            }
//
//            if (lastPossibleIndex == index) {
//                return false;
//            } else if (lastPossibleIndex == 0) {
//                break;
//            } else {
//                index = lastPossibleIndex;
//                visited[index] = true;
//            }
//        }
//
//        return true;
//    }
//
//    // Apply BS
//    public static int maxJump(int[] stones) {
//        int low = stones[1] - stones[0];
//        int high = stones[stones.length - 1] - stones[0];
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (isPossibleToTravelInMaxCurrentJump(mid, stones)) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//
//        return low;
//    }

    public static void main(String[] args) {
        System.out.println(maxJump(new int[]{0, 2, 5, 6, 7}));
        System.out.println(maxJump(new int[]{0, 3, 9}));
    }

//    private static int maxJump(int currentIndex, int[] newStones, Set<Integer> visited) {
//        if (currentIndex == newStones.length - 1) {
//            return 0;
//        }
//
//        int minimumCost = Integer.MAX_VALUE;
//
//        int halfLength = newStones.length / 2;
//        int endIndex;
//
//        if (currentIndex < halfLength) {
//            endIndex = halfLength;
//        } else {
//            endIndex = newStones.length - 1;
//        }
//
//        for (int i = currentIndex + 1; i <= endIndex; i++) {
//            if (!visited.contains(newStones[i])) {
//                visited.add(newStones[i]);
//                int currentJump = Math.abs(newStones[i] - newStones[currentIndex]);
//                int recursiveJump = maxJump(i, newStones, visited);
//                minimumCost = Math.min(minimumCost, Math.max(currentJump, recursiveJump));
//                visited.remove(newStones[i]);
//            }
//        }
//
//        return minimumCost;
//    }
//
//    public static int maxJump(int[] stones) {
//
//        int n = stones.length;
//        int[] newStones = new int[2 * n - 1];
//
//        System.arraycopy(stones, 0, newStones, 0, n);
//
//        // 0 1 2 becomes 0 1 2 1 0
//
//        int index = stones.length - 2;
//
//        for (int i = stones.length; i < 2 * stones.length - 1; i++) {
//            newStones[i] = stones[index--];
//        }
//
//        Set<Integer> visited = new HashSet<>();
//        return maxJump(0, newStones, visited);
//    }
}