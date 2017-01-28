package com.baiye.test.Task;

import com.baiye.annotation.SchedulerTask;
import com.baiye.annotation.TaskClass;
import com.baiye.annotation.TaskMethod;
import com.baiye.container.Container;
import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.container.SimpleTaskLocalContainer;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService executorService  = Executors.newFixedThreadPool(4);
        Container container = new SchedulerTaskLocalContainer("com.baiye.test.Task");
        executorService.execute(container);
        executorService.shutdown();
    }

}
