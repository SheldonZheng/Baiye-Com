package com.baiye.container;


/**
 * Created by Baiye on 2017/1/19.
 */
public interface Container{
    void addTasks(String packageName);

    void addTasks(String packageName, String jarFilePath);
}
