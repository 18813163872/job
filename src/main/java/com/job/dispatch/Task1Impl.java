package com.job.dispatch;

/**
 * realize task definition
 */
public class Task1Impl implements TaskDefinition {

    @Override
    public synchronized void doTask() {
        System.out.println("[thread:"+Thread.currentThread().getName() + "]-task 1 do something 。。。。。。");
    }

}
