package com.example.initialization;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @program: springbooot-practice
 * @description:
 * @author: xrwang8
 * @create: 2021-06-26 21:33
 **/
@Component
@Slf4j
public class GroovyClassLoaderDemo implements ApplicationListener<ApplicationContextEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(systemClassLoader);
        Class aClass = null;
        try {
            aClass = groovyClassLoader.parseClass(new File("groovy-practice/src/main/resources/groovyClass/GroovyClassLoaderDemo.groovy"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroovyObject object;
        try {
            object = (GroovyObject) aClass.newInstance();
            Object res = object.invokeMethod("sayHello", "GroovyClassLoader");
            log.info("GroovyClassLoader的运行结果：{}", res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
