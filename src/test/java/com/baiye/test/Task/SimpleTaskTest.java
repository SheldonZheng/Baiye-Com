package com.baiye.test.Task;

import com.baiye.annotation.TaskClass;
import com.baiye.annotation.TaskMethod;
import com.baiye.task.SimpleTask;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Baiye on 2017/1/19.
 */
@TaskClass
public class SimpleTaskTest {

    @TaskMethod
    public void test()
    {
        System.out.println("SimpleTaskTest success!");
    }


    @Test
    public void simpleTaskTest()
    {
        ExecutorService executorService  = Executors.newFixedThreadPool(4);
        SimpleTask simpleTask = new SimpleTask("com.baiye.test.Task");
        executorService.execute(simpleTask);
        executorService.shutdown();
    }
}
