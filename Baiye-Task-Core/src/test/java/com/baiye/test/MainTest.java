package com.baiye.test;


import com.baiye.test.task.SchedulerTaskLocalContainerTest;
import com.baiye.test.task.SimpleTaskLocalContainerTest;
import com.baiye.test.web.InterfaceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Baiye on 2017/1/19.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({InterfaceTest.class,
        SchedulerTaskLocalContainerTest.class,
        SimpleTaskLocalContainerTest.class})
public class MainTest {

}
