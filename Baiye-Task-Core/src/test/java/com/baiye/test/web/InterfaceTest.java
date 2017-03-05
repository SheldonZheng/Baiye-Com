package com.baiye.test.web;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


/**
 * Created by Baiye on 2017/2/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InterfaceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void healthCheckTest()
    {
        String res = restTemplate.getForObject("/healthCheck",String.class);
        assertThat(res,is("ok"));
    }

    @Test
    public void runningTasksTest()
    {
        String res = restTemplate.getForObject("/runningTasks",String.class);
        assertThat(res, containsString("success"));
    }

    @Test
    public void cancelTaskFailTest()
    {
        Map<String,Object> params = Maps.newHashMap();
        params.put("taskName","1");
        String res = restTemplate.getForObject("/cancelTask?taskName={taskName}",String.class,params);
        assertThat(res,containsString("failed"));
    }

}
