package com.baiye.test;

import com.baiye.test.taskTest.SchedulerTaskLocalContainerTest;
import com.baiye.test.taskTest.SimpleTaskLocalContainerTest;
import com.baiye.test.helper.ClassTestHelper;

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
