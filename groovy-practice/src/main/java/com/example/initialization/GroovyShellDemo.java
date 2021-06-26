package com.example.initialization;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @program: springbooot-practice
 * @description:
 * @author: xrwang8
 * @create: 2021-06-26 20:16
 **/
@Slf4j
@Component
public class GroovyShellDemo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Binding binding = new Binding();
        binding.setVariable("name", "GroovyShell");
        GroovyShell groovyShell = new GroovyShell(binding);
        Object res = groovyShell.evaluate(new File("groovy-practice/src/main/resources/groovy/GroovyShellDemo.groovy"));
        log.info("GroovyShell的执行结果:{}", res.toString());
    }
}
