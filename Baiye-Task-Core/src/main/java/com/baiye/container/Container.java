package com.baiye.container;


import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Baiye on 2017/1/19.
 */
public interface Container{
    void addTasks(String packageName, String jarFilePath) throws MalformedURLException, ExecutionException;
}
