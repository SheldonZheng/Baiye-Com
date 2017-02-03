package com.baiye.test.taskTest;

import com.baiye.annotation.TaskClass;
import com.baiye.annotation.TaskMethod;
import com.baiye.container.Container;
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
        System.out.println("SimpleTaskLocalContainer testPackage success!");
    }


    @Test
    public void simpleTaskTest()
    {
        ExecutorService executorService  = Executors.newFixedThreadPool(4);
        Container container = new SimpleTaskLocalContainer("com.baiye.test.taskTest");
        executorService.execute(container);
        executorService.shutdown();
    }
}