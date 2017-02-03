package com.baiye.test.taskTest;

import com.baiye.test.helper.ClassTestHelper;

/**
 * Created by Baiye on 2017/2/3.
 */
public class TestPackage {

    public static void main(String[] args) {
        testPackage();
    }

    public static void testPackage()
    {
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
