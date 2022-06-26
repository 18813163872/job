package com.job;

import com.job.dispatch.*;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobApplicationTests {

    @Test
    void contextLoads() {
        TaskDefinition taskDefinition1 = new Task1Impl();
        TaskDefinition taskDefinition2 = new Task2Impl();
        TaskCenter taskCenter = new TaskCenter();
        TaskStrategy taskStrategy1 = new TaskStrategy(1, null, "task1");
        TaskStrategy taskStrategy2 = new TaskStrategy(10, 10000, "task2");
        taskCenter.add(new Pair(taskStrategy1, taskDefinition1));
        taskCenter.add(new Pair(taskStrategy2, taskDefinition2));
        Dog.doTask();

        //  get task
        TaskCenter.task.parallelStream().forEach(t-> System.out.println(t.getKey()));

        //  update task
        TaskStrategy taskStrategy3 = new TaskStrategy(10, 10000, "task2");
        Pair pair = new Pair(taskStrategy3, taskDefinition2);
        taskCenter.add(new Pair(taskStrategy3, taskDefinition2));
        TaskCenter.task.parallelStream().forEach(t-> System.out.println(t));
        Dog.doTask();

        //  remove task
        taskCenter.remove(pair);
    }

}
