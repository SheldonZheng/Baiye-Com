package com.baiye.service.impl;

import com.baiye.service.ClassScanerService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by hang.zheng on 2017/3/7.
 */
@Service
public class ClassScanerServiceImpl implements ClassScanerService{

    @Override
    public Set<Class<?>> getClasses(String packageName, String jarFilePath) {
        return null;
    }
}
