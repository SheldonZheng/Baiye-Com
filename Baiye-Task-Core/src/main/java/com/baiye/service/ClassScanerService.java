package com.baiye.service;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created by hang.zheng on 2017/3/7.
 */
public interface ClassScanerService {

    Set<Class<?>> getClasses(String packageName,String jarFilePath) throws MalformedURLException, ExecutionException;


}
