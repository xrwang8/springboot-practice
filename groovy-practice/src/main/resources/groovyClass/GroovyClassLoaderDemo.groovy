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
        String  name = map.get("name");
        if (name != "王兴瑞") {
            Map maps = new HashMap<String, String>();
            maps.put("name", "姓名校验不通过")
            return maps
        }
        for (v in map) {
            println v
        }
    }
}
