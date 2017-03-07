package com.baiye.service;

import java.util.Set;

/**
 * Created by hang.zheng on 2017/3/7.
 */
public interface ClassScanerService {

    Set<Class<?>> getClasses(String packageName,String jarFilePath);

}
