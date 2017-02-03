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
    }

    @Override
    public void runTests()
    {
        ClassTestHelper.testClass(SimpleTaskLocalContainerTest.class);
        ClassTestHelper.testClass(SchedulerTaskLocalContainerTest.class);
    }
}
