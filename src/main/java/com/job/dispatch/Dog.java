package com.job.dispatch;

/**
 * dispatch dog
 */
public class Dog {

    public Dog() {
    }

    public static void doTask() {
        for (int i = 0; i < TaskCenter.task.size(); i++) {
            TaskStrategy taskStrategy = (TaskStrategy) TaskCenter.task.get(i).getKey();
            if (TaskCenter.taskDone.contains(taskStrategy.getTaskName())) {
                return;
            }
            TaskDefinition taskDefinition = (TaskDefinition) TaskCenter.task.get(i).getValue();
            Thread t = new JobThread(taskStrategy, taskDefinition);
            t.setName(taskStrategy.getTaskName());
            t.setDaemon(false);
            t.start();
            t.run();
            TaskCenter.taskDone.add(taskStrategy.getTaskName());
        }
    }

}

class JobThread extends Thread {

    private TaskStrategy taskStrategy;
    private TaskDefinition taskDefinition;

    public JobThread(TaskStrategy taskStrategy, TaskDefinition taskDefinition) {
        this.taskStrategy = taskStrategy;
        this.taskDefinition = taskDefinition;
    }

    private volatile Integer num;

    public void run() {
        num = taskStrategy.getDoNum();
        while (num>0) {
            taskDefinition.doTask();
            try {
                if (null != taskStrategy.getTime()) {
                    Thread.sleep(taskStrategy.getTime());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            num=num-1;

        }
    }

}
