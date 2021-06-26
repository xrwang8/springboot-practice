package com.example.initialization;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springbooot-practice
 * @description:
 * @author: xrwang8
 * @create: 2021-06-26 20:26
 **/
@Component
@Slf4j
public class GroovyScriptEngineDemo implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine("groovy-practice/src/main/resources/groovy/");
        Binding binding = new Binding();
        binding.setVariable("name", "GroovyScriptEngine");
        Map<String, String> maps = new HashMap<>();
        maps.put("type", "GroovyScriptEngine");
        maps.put("authotr", "叫我小王八");
        binding.setVariable("map", maps);
        Object res = groovyScriptEngine.run("GroovyScriptEngineDemo.groovy", binding);
        log.info("GroovyScriptEngine的运行结果：{}", res.toString());

    }
}
