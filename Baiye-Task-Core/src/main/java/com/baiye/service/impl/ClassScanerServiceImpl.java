package com.baiye.service.impl;

import com.baiye.classloader.BaiyeClassLoader;
import com.baiye.service.ClassScanerService;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * Created by hang.zheng on 2017/3/7.
 */
@Service
public class ClassScanerServiceImpl implements ClassScanerService{

    private Logger logger = LoggerFactory.getLogger(ClassScanerServiceImpl.class);

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
        Set<Class<?>> classSet = getClassSet(packageName,classLoader,jarFilePath);

        return classSet;
    }


    /**
     * 为每一个jar包创建一个私有的ClassLoader
     * @param packageName
     * @param file
     * @return
     * @throws ExecutionException
     * @throws MalformedURLException
     */
    private ClassLoader getClassLoader(String packageName,File file) throws ExecutionException, MalformedURLException {
        ClassLoader classLoader = classLoaderCache.get(file.getName().concat(packageName));
        if(classLoader != null) {
            return classLoader;
        } else {
            URL url = file.toURI().toURL();
            BaiyeClassLoader baiyeClassLoader = new BaiyeClassLoader(new URL[]{url});
            baiyeClassLoader.addURL(url);
            classLoaderCache.put(file.getName().concat(packageName),baiyeClassLoader);
            return baiyeClassLoader;
        }
    }

    private Set<Class<?>> getClassSet(String packageName,ClassLoader classLoader,String jarFilePath)
    {
        Set<Class<?>> classSet = Sets.newHashSet();

        try {
            JarFile jarFile = new JarFile(jarFilePath);
            if(jarFile != null)
            {
                Enumeration<JarEntry> entrys = jarFile.entries();
                while(entrys.hasMoreElements()) {
                    String jarEntryName = entrys.nextElement().getName();
                    if(StringUtils.isNotBlank(jarEntryName) && jarEntryName.endsWith(".class")) {
                        String clsName = getClassName(jarEntryName);
                        Class cls = classLoader.loadClass(clsName);
                        if(cls != null)
                            classSet.add(cls);
                    }
                }
            }
        } catch (IOException e) {
            logger.error("get class set failure{}",e);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            logger.error("get class set failure{}",e);
            e.printStackTrace();
        }
        return null;
    }

    private static String getClassName(String jarEntryName) {
        if (jarEntryName.endsWith(".class")) {
            return jarEntryName.replace("/", ".").substring(0, jarEntryName.lastIndexOf("."));
        }
        return null;
    }
}
