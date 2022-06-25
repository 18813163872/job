package com.job.dispatch;

import java.io.Serializable;

/**
 * task strategy
 */
public class TaskStrategy implements Serializable {
    /**
     * do num when -1 can Has been performed
     */
    private Integer doNum;
    /**
     * cycle do interval time s
     */
    private Integer time;
    /**
     * task name
     */
    private String taskName;

    public TaskStrategy(Integer num, Integer time, String taskName) {
        setTaskName(taskName);
        setDoNum(num);
        setTime(time);
    }

    public Integer getDoNum() {
        return doNum;
    }

    public void setDoNum(Integer doNum) {
        this.doNum = doNum;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}
