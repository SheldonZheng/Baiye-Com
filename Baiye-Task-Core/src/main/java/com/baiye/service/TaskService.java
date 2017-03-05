package com.baiye.service;

import java.util.List;

/**
 * Created by Baiye on 2017/2/4.
 */
public interface TaskService {

    void addTask(String jarFilePath, String packageName);

    List<String> runningTasks();
}
