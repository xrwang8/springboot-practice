def rules = [
        [
                "expression": ' v_name != null && v_name.length()>0  ',
                "tip"       : "姓名必填"
        ],
        [
                "target"    : ['v_password', 'v_password_twice'],
                "expression": ' v_password == v_password_twice  ',
                "tip"       : "两次密码必须一致"
        ]
]

def map = [
        "v_name"          : '',
        "v_password"      : "abc",
        "v_password_twice": "abc",
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