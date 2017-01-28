package com.baiye.test;

import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.container.SimpleTaskLocalContainer;
import com.baiye.test.Task.SchedulerTaskLocalContainerTest;
import com.baiye.test.Task.SimpleTaskLocalContainerTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Baiye on 2017/1/19.
 */
public class MainTest {

    public static void main(String[] args) {
        testClass(SimpleTaskLocalContainerTest.class);
        testClass(SchedulerTaskLocalContainerTest.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }


    private static void testClass(Class cls)
    {
        Result result = JUnitCore.runClasses(cls);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
