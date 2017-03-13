package com.baiye.test.task;

import com.baiye.annotation.SchedulerTask;
import com.baiye.annotation.TaskClass;
import com.baiye.container.Container;
import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.single.SingleMapEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by Baiye on 28/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SchedulerTaskLocalContainerTest {

    @Autowired
    @Qualifier("schedulerTaskLocalContainer")
    private Container container;

    @Autowired
    @Qualifier("taskFutureMap")
    private Map<String, ScheduledFuture> scheduledFutureMap;

    @Test
    public void schedulerTaskTest() throws MalformedURLException, ExecutionException {
        container.addTasks("com.baiye.test.task","D:\\Source\\Baiye-Task\\others\\test.jar");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
/*
    @Test
    public void addTaskTest()
    {
        Container container = new SchedulerTaskLocalContainer();
        container.addTasks("com.baiye.test.taskTest1","D:\\Source\\Baiye-Task\\others\\test.jar");

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
    }*/
}
