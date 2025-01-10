package org.example.Bi_Weekly._147;

import java.util.*;

//public class Q2_Design_Task_Manager {
//
//}

class Helper {
    int userId;
    int taskId;
    int priorityId;

    public Helper(int userId, int taskId, int priorityId) {
        this.userId = userId;
        this.taskId = taskId;
        this.priorityId = priorityId;
    }

    @Override
    public String toString() {
        return "Helper{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                ", priorityId=" + priorityId +
                '}';
    }
}

public class TaskManager {

    Comparator<Helper> helperComparator = (o1, o2) -> {
        if (o1.priorityId > o2.priorityId) {
            return 1;
        } else if (o1.priorityId == o2.priorityId) {
            if (o1.taskId > o2.taskId) {
                return 1;
            } else if (o1.taskId < o2.taskId) {
                return -1;
            }
            return 0;
        }
        return -1;
    };

    public PriorityQueue<Helper> priorityQueue = new PriorityQueue<>(helperComparator);
    public Map<Integer, List<Helper>> taskIdToTaskHelper = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> currentTask : tasks) {
            Helper helper = new Helper(currentTask.getFirst(), currentTask.get(1), currentTask.getLast());
            priorityQueue.add(helper);

            if (!taskIdToTaskHelper.containsKey(currentTask.get(1))) {
                taskIdToTaskHelper.put(currentTask.get(1), new ArrayList<>());
            }
            taskIdToTaskHelper.get(currentTask.get(1)).add(helper);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Helper helper = new Helper(userId, taskId, priority);
        priorityQueue.add(helper);

        if (!taskIdToTaskHelper.containsKey(taskId)) {
            taskIdToTaskHelper.put(taskId, new ArrayList<>());
        }
        taskIdToTaskHelper.get(taskId).add(helper);
    }

    public void edit(int taskId, int newPriority) {
        List<Helper> tasksWithGivenPriority = taskIdToTaskHelper.get(taskId);
        List<Helper> updatedTaskListForGivenPriority = new ArrayList<>();

        for (Helper currentTask : tasksWithGivenPriority) {
            priorityQueue.remove(currentTask);
            Helper helper = new Helper(currentTask.userId, currentTask.taskId, newPriority);
            priorityQueue.add(helper);
            updatedTaskListForGivenPriority.add(helper);
        }
        taskIdToTaskHelper.get(taskId).clear();
        taskIdToTaskHelper.get(taskId).addAll(updatedTaskListForGivenPriority);
    }

    public void rmv(int taskId) {
        List<Helper> tasksWithGivenPriority = taskIdToTaskHelper.get(taskId);
        for (Helper currentTask : tasksWithGivenPriority) {
            priorityQueue.remove(currentTask);
        }
        taskIdToTaskHelper.get(taskId).clear();
    }

    public int execTop() {
        if (priorityQueue.isEmpty()) {
            return -1;
        }
        Helper mostPriorityTask = priorityQueue.remove();
        List<Helper> tasksWithGivenPriority = taskIdToTaskHelper.get(mostPriorityTask.taskId);
        tasksWithGivenPriority.remove(mostPriorityTask);
        return mostPriorityTask.userId;
    }
}