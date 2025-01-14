package org.example.Bi_Weekly._147;

import java.util.*;

public class _3408_Design_Task_Manager {
}

class TaskManager {

    Comparator<Task> priorityThenTaskIdComparator = (o1, o2) -> {
        if (o2.priorityId > o1.priorityId) {
            return 1;
        } else if (o1.priorityId == o2.priorityId) {
            if (o2.taskId > o1.taskId) {
                return 1;
            } else if (o1.taskId > o2.taskId) {
                return -1;
            }
            return 0;
        }
        return -1;
    };

    public PriorityQueue<Task> highestPriorityTaskQueue;
    public Map<Integer, Task> taskIdToTaskMapping;

    public TaskManager(List<List<Integer>> tasks) {
        highestPriorityTaskQueue = new PriorityQueue<>(priorityThenTaskIdComparator);
        taskIdToTaskMapping = new HashMap<>();

        for (List<Integer> currentTask : tasks) {
            add(currentTask.getFirst(), currentTask.get(1), currentTask.getLast());
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task taskToBeAdded = new Task(userId, taskId, priority, false);
        highestPriorityTaskQueue.add(taskToBeAdded);
        taskIdToTaskMapping.put(taskId, taskToBeAdded);
    }

    public void edit(int taskId, int newPriority) {
        Task taskWithGivenPriority = taskIdToTaskMapping.get(taskId);
        taskWithGivenPriority.expired = true;
        add(taskWithGivenPriority.userId, taskId, newPriority);
    }

    public void rmv(int taskId) {
        Task taskToBeRemoved = taskIdToTaskMapping.get(taskId);
        taskToBeRemoved.expired = true;
    }

    // We are not deleting task from HashMap ever.
    // Task is deleted from PQ also only when execTop() is called, not in edit() and rmv()
    public int execTop() {
        if (highestPriorityTaskQueue.isEmpty()) {
            return -1;
        }

        while (!highestPriorityTaskQueue.isEmpty()) {
            Task mostPriorityTask = highestPriorityTaskQueue.remove();
            if (mostPriorityTask.expired) {
                continue;
            }
            return mostPriorityTask.userId;
        }

        return -1;
    }
}

class Task {
    int userId;
    int taskId;
    int priorityId;
    // When we have to remove a random task. Then TC will be very large. So we will use this flag
    // to determine whether task is expired or not.
    boolean expired;

    public Task(int userId, int taskId, int priorityId, boolean expired) {
        this.userId = userId;
        this.taskId = taskId;
        this.priorityId = priorityId;
        this.expired = expired;
    }
}