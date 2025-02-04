package org.example.Bi_Weekly._149;

import java.util.*;

public class Q2_Reschedule_Meetings_for_Maximum_Free_Time_I {

    static class Helper {
        int startTime;
        int endTime;
        int leftVacantSpace;
        int rightVacantSpace;

        public Helper(int startTime, int endTime, int leftVacantSpace, int rightVacantSpace) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.leftVacantSpace = leftVacantSpace;
            this.rightVacantSpace = rightVacantSpace;
        }

        @Override
        public String toString() {
            return "Helper{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", leftVacantSpace=" + leftVacantSpace +
                    ", rightVacantSpace=" + rightVacantSpace +
                    '}';
        }
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int numberOfEvents = startTime.length;

        if (numberOfEvents == 1) {
            if (k != 0) {
                return eventTime - (endTime[0] - startTime[0]);
            } else {
                return Math.max(startTime[0], eventTime - endTime[0]);
            }
        }

        int maxFreeTime = 0;

        Comparator<Integer> maxVacantIndexMapper = (o1, o2) -> {

            int o1LeftVacantSpace = (o1 == 0) ? (startTime[o1]) : (startTime[o1] - endTime[o1 - 1]);
            int o2LeftVacantSpace = (o2 == 0) ? (startTime[o2]) : (startTime[o2] - endTime[o2 - 1]);

            int o1RightVacantSpace = (o1 == numberOfEvents - 1) ? (eventTime - endTime[o1]) : (startTime[o1 + 1] - endTime[o1]);
            int o2RightVacantSpace = (o2 == numberOfEvents - 1) ? (eventTime - endTime[o2]) : (startTime[o2 + 1] - endTime[o2]);

            int o1VacantSpace = Math.max(o1LeftVacantSpace, o1RightVacantSpace);
            int o2VacantSpace = Math.max(o2LeftVacantSpace, o2RightVacantSpace);

            return Integer.compare(o1VacantSpace,o2VacantSpace);

//            if (o2VacantSpace - o1VacantSpace > 0) {
//                return 1;
//            } else if (o2VacantSpace - o1VacantSpace < 0) {
//                return -1;
//            }
//            return 0;
        };

        TreeMap<Integer, Helper> indexToHelperMapping = new TreeMap<>(maxVacantIndexMapper);

        for (int i = 0; i < numberOfEvents; i++) {
            Helper currentHelper;
            if (i == 0) {
                currentHelper = new Helper(startTime[i], endTime[i], startTime[i], startTime[i + 1] - endTime[i]);
            } else if (i == numberOfEvents - 1) {
                currentHelper = new Helper(startTime[i], endTime[i], startTime[i] - endTime[i - 1], eventTime - endTime[i]);
            } else {
                currentHelper = new Helper(startTime[i], endTime[i], startTime[i] - endTime[i - 1], startTime[i + 1] - endTime[i]);
            }
            maxFreeTime = Math.max(maxFreeTime, Math.max(currentHelper.leftVacantSpace, currentHelper.rightVacantSpace));
            indexToHelperMapping.put(i, currentHelper);
        }

        System.out.println(indexToHelperMapping);

        if (k == 0) {
            return maxFreeTime;
        }

        while (k != 0) {
            Map.Entry<Integer, Helper> firstEntry = indexToHelperMapping.firstEntry();
            int index = firstEntry.getKey();
            Helper currentHelper = firstEntry.getValue();

            indexToHelperMapping.remove(index);

            Helper newCurrentHelper;

            Helper leftHelper = (index != 0) ? indexToHelperMapping.get(index - 1) : null;
            Helper rightHelper = (index != numberOfEvents - 1) ? indexToHelperMapping.get(index + 1) : null;

            // Move Current Event to Left If Possible,
            // If not Possible, Move Current Event To Right

            // If Left Vacant Space available, definitely move to left
            if (currentHelper.leftVacantSpace != 0) {
                newCurrentHelper = new Helper(currentHelper.startTime - currentHelper.leftVacantSpace, currentHelper.endTime - currentHelper.leftVacantSpace,
                        0, currentHelper.rightVacantSpace + currentHelper.leftVacantSpace);

                if (leftHelper != null) {
                    Helper newLeftHelper = new Helper(leftHelper.startTime, leftHelper.endTime, leftHelper.leftVacantSpace, 0);
                    indexToHelperMapping.remove(index - 1);
                    indexToHelperMapping.put(index - 1, newLeftHelper);
                    maxFreeTime = Math.max(maxFreeTime, Math.max(newLeftHelper.leftVacantSpace, newLeftHelper.rightVacantSpace));
                }

                if (rightHelper != null) {
                    Helper newRightHelper = new Helper(rightHelper.startTime, rightHelper.endTime, rightHelper.leftVacantSpace + currentHelper.leftVacantSpace, rightHelper.rightVacantSpace);
                    indexToHelperMapping.remove(index + 1);
                    indexToHelperMapping.put(index + 1, newRightHelper);
                    maxFreeTime = Math.max(maxFreeTime, Math.max(newRightHelper.leftVacantSpace, newRightHelper.rightVacantSpace));
                }
            }
            // If Left Vacant Space not available move to right as no option is there.
            else {
                newCurrentHelper = new Helper(currentHelper.startTime + currentHelper.rightVacantSpace, currentHelper.endTime + currentHelper.rightVacantSpace,
                        currentHelper.leftVacantSpace + currentHelper.rightVacantSpace, 0);
                if (leftHelper != null) {
                    Helper newLeftHelper = new Helper(leftHelper.startTime, leftHelper.endTime, leftHelper.leftVacantSpace, leftHelper.rightVacantSpace + currentHelper.rightVacantSpace);
                    indexToHelperMapping.remove(index - 1);
                    indexToHelperMapping.put(index - 1, newLeftHelper);
                    maxFreeTime = Math.max(maxFreeTime, Math.max(newLeftHelper.leftVacantSpace, newLeftHelper.rightVacantSpace));
                }

                if (rightHelper != null) {
                    Helper newRightHelper = new Helper(rightHelper.startTime, rightHelper.endTime, 0, rightHelper.rightVacantSpace);
                    indexToHelperMapping.remove(index + 1);
                    indexToHelperMapping.put(index + 1, newRightHelper);
                    maxFreeTime = Math.max(maxFreeTime, Math.max(newRightHelper.leftVacantSpace, newRightHelper.rightVacantSpace));
                }
            }

            indexToHelperMapping.put(index, newCurrentHelper);
            maxFreeTime = Math.max(maxFreeTime, Math.max(newCurrentHelper.leftVacantSpace, newCurrentHelper.rightVacantSpace));
            k--;
        }

        return maxFreeTime;
    }
}
