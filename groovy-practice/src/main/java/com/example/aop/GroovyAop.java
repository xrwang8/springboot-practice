package com.example.aop;

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @program: springbooot-practice
 * @description:
 * @author: xrwang8
 * @create: 2021-06-26 11:59
 **/
@Aspect
@Component
@Slf4j
public class GroovyAop {

    /*** 
     * @Description: 切入所有被GroovyTest注解修饰的函数
     * @Param: []
     * @return: void
     * @Author: xrwang8
     */
    @Pointcut("@annotation(com.example.annotation.GroovyTest)")
    public void GroovyPoint() {
    }

    @Around("GroovyPoint()")
    public Object GrovvyTest(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        Map<String, Object> dataMaps = BeanUtil.beanToMap(args[0]);
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
            Object res = object.invokeMethod("checkData", dataMaps);
            log.info("GroovyClassLoader的运行结果：{}", res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return args;
    }

}
