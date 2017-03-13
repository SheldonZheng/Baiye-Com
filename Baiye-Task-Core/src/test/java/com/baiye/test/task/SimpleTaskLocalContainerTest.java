package com.baiye.test.task;

import com.baiye.container.Container;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Baiye on 2017/1/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleTaskLocalContainerTest {

    @Autowired
    @Qualifier("simpleTaskLocalContainer")
    private Container container;

    @Test
    public void simpleTaskTest()
    {
        try {
            container.addTasks("com.baiye.test.task","D:\\Source\\Baiye-Task\\others\\test.jar");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
