def rules = [

        [
                "expression": ' name != null && name.length()>0  ',
                "tip"       : "姓名必填"
        ],
]


def check(List rules, def map) {
    def sharedData = new Binding()
    def shell = new GroovyShell(sharedData)
    sharedData.setProperty("length", { s ->
        if (s == null) return 0
        return s.length()
    })
    map.each { k, v ->
        sharedData.setProperty(k, v)
    }

    rules.findAll { !shell.evaluate(it.expression) }
}

check(rules, map).each {
    println(it.tip)
}