package com.baiye.test.taskTest;

import com.baiye.annotation.SchedulerTask;
import com.baiye.annotation.TaskClass;
import com.baiye.container.Container;
import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.single.SingleMapEnum;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by Baiye on 28/01/2017.
 */
@TaskClass
public class SchedulerTaskLocalContainerTest {

    @SchedulerTask(name = "test1",firstDelay = 1000,delay = 1000)
    public void test()
    {
        System.out.println("SchedulerTaskLocalContainer test success!");
    }

   @Test
    public void schedulerTaskTest()
    {
        Container container = new SchedulerTaskLocalContainer();
        container.addTasks("com.baiye.test.taskTest");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String,ScheduledFuture> scheduledFutureMap = SingleMapEnum.LocalTaskFutureSingleMap.getMap();
        for (Map.Entry<String, ScheduledFuture> entry : scheduledFutureMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            try {
                Thread.sleep(5000);
                entry.getValue().cancel(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void addTaskTest()
    {
        Container container = new SchedulerTaskLocalContainer();
        container.addTasks("com.baiye.test.taskTest1","D:\\test.jar");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String,ScheduledFuture> scheduledFutureMap = SingleMapEnum.LocalTaskFutureSingleMap.getMap();
        for (Map.Entry<String, ScheduledFuture> entry : scheduledFutureMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            try {
                Thread.sleep(5000);
                entry.getValue().cancel(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
