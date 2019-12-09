package com.hmtmcse.devops.test

import com.hmtmcse.jtfutil.parser.JacksonYml

class Test {


    public static void main(String[] args) {

        JacksonYml jacksonYml = new JacksonYml()
        Map map = [
                "data1" : new Data1("Data 1 Data"),
                "data2" : new Data2("Data 2 Data"),
        ]
        println(jacksonYml.klassToString(map))

    }

}
