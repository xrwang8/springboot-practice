package groovyClass

/**
 * @program: springbooot-practice
 * @description: ${description}* @author: xrwang8* @create: 2021-06-26 21:54
 * */
class GroovyClassLoaderDemo {

    String sayHello(String name) {
        return "GroovyShellDemo." + name
    }

    Map<String, String> checkData(Map map) {
        for (v in map) {
            println v
        }
    }
}
