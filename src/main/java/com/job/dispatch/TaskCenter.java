package com.job.dispatch;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * task center
 */
public class TaskCenter {

    /**
     * task manager center
     */
    public static List<Pair<TaskStrategy, TaskDefinition>> task = Collections.synchronizedList(new ArrayList<>());

    /**
     * has done task
     */
    public static List<String> taskDone = Collections.synchronizedList(new ArrayList<>());

    /**
     * add task
     */
    public void add(Pair pair) {
        task.add(pair);
    }

    /**
     * remove task
     */
    public void remove(Pair pair) {
        task.remove(pair);
    }

}
