package com.baiye.service.impl;

import com.baiye.classloader.BaiyeClassLoader;
import com.baiye.service.ClassScanerService;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created by hang.zheng on 2017/3/7.
 */
@Service
public class ClassScanerServiceImpl implements ClassScanerService{

    @Autowired
    @Qualifier("classLoaderCache")
    private LoadingCache<String,ClassLoader> classLoaderCache;

    @Override
    public Set<Class<?>> getClasses(String packageName, String jarFilePath) throws MalformedURLException, ExecutionException {
        File file = new File(jarFilePath);
        if(!file.exists()) {
            throw new RuntimeException("jar文件不存在!");
        }
        ClassLoader classLoader = getClassLoader(packageName,file);

        return null;
    }


    private ClassLoader getClassLoader(String packageName,File file) throws ExecutionException, MalformedURLException {
        ClassLoader classLoader = classLoaderCache.get(file.getName().concat(packageName));
        if(classLoader != null) {
            return classLoader;
        } else {
            URL url = file.toURI().toURL();
            BaiyeClassLoader baiyeClassLoader = new BaiyeClassLoader(new URL[]{url});
            classLoaderCache.put(file.getName().concat(packageName),baiyeClassLoader);
            return baiyeClassLoader;
        }
    }

}
