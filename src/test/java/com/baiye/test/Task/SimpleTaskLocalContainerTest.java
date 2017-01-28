package com.baiye.test.Task;

import com.baiye.annotation.TaskClass;
import com.baiye.annotation.TaskMethod;
import com.baiye.container.SimpleTaskLocalContainer;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Baiye on 2017/1/19.
 */
@TaskClass
public class SimpleTaskLocalContainerTest {

    @TaskMethod
    public void test()
    {
        System.out.println("SimpleTaskLocalContainer test success!");
    }


    @Test
    public void simpleTaskTest()
    {
        ExecutorService executorService  = Executors.newFixedThreadPool(4);
        SimpleTaskLocalContainer simpleTask = new SimpleTaskLocalContainer("com.baiye.test.Task");
        executorService.execute(simpleTask);
        executorService.shutdown();
    }
}
