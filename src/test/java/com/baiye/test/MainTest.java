package com.baiye.test;

import com.baiye.container.SchedulerTaskLocalContainer;
import com.baiye.container.SimpleTaskLocalContainer;
import com.baiye.test.Task.SchedulerTaskLocalContainerTest;
import com.baiye.test.Task.SimpleTaskLocalContainerTest;
import com.baiye.test.helper.ClassTestHelper;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Baiye on 2017/1/19.
 */
public class MainTest {

    public static void main(String[] args) {
        ClassTestHelper.testClass(SimpleTaskLocalContainerTest.class);
        ClassTestHelper.testClass(SchedulerTaskLocalContainerTest.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }



}
