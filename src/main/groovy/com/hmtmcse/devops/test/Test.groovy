package com.hmtmcse.devops.test

import com.hmtmcse.jtfutil.parser.JacksonYml

class Test {


    public static void main(String[] args) {

        JacksonYml jacksonYml = new JacksonYml()
        Map map = [
                "data1" : new Data1("Data 1 Data"),
                "data2" : new Data2("Data 2 Data"),
        ]


        List actions = []
        Map task = [
                "operation" : "Copy to home",
                "action" : "copy",
                "input": new Data1("Data 1 Data")
        ]
        actions.add(task)

        task = [
                "operation" : "Copy to temp",
                "action" : "copy",
                "input": new Data1("Data 1 Data")
        ]
        actions.add(task)




        println(jacksonYml.klassToString(actions))

    }

}
