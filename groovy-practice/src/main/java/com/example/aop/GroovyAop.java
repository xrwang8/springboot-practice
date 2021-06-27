package com.example.aop;

import cn.hutool.core.bean.BeanUtil;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution(* com.example.controller..*(..))")
    public void requestServer() {
    }

    @Around("GroovyPoint()")
    public Object GrovvyTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
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
            object.invokeMethod("checkData", dataMaps);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        Object result = proceedingJoinPoint.proceed();
        return result;


    }


}
