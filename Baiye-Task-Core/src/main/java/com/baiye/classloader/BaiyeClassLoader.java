package com.baiye.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.*;
import java.lang.ClassLoader;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.jar.Manifest;

/**
 * Created by Baiye on 2017/2/4.
 */
public class BaiyeClassLoader extends URLClassLoader{
    public BaiyeClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public BaiyeClassLoader(URL[] urls) {
        super(urls);
    }

    public BaiyeClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        return super.getResourceAsStream(name);
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    protected void addURL(URL url) {
        super.addURL(url);
    }

    @Override
    public URL[] getURLs() {
        return super.getURLs();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    protected Package definePackage(String name, Manifest man, URL url) throws IllegalArgumentException {
        return super.definePackage(name, man, url);
    }

    @Override
    public URL findResource(String name) {
        return super.findResource(name);
    }

    @Override
    public Enumeration<URL> findResources(String name) throws IOException {
        return super.findResources(name);
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codesource) {
        return super.getPermissions(codesource);
    }

    public void addURL(URL...url)
    {
        for (URL url1 : url) {
            addURL(url1);
        }
    }
}
