package com.baiye.test.taskTest;

import com.baiye.test.TestPackage;
import com.baiye.test.helper.ClassTestHelper;

/**
 * Created by Baiye on 2017/2/3.
 */
public class TaskTestPackage implements TestPackage{

    public static void main(String[] args) {
        TestPackage testPackage = new TaskTestPackage();
        testPackage.runTests();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    @Override
    public void runTests()
    {
        ClassTestHelper.testClass(SimpleTaskLocalContainerTest.class);
        ClassTestHelper.testClass(SchedulerTaskLocalContainerTest.class);
    }
}
