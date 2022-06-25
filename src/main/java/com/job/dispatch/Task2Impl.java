package com.job.dispatch;

/**
 * realize task definition
 */
public class Task2Impl implements TaskDefinition {

    @Override
    public synchronized void doTask() {
        System.out.println("[thread:"+Thread.currentThread().getName() + "]task 2 do something 。。。。。。");
    }

}
