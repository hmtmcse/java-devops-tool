package com.hmtmcse.devops.system.processor

import com.hmtmcse.jtfutil.parser.JacksonYml

class YmlProcessor {

    public String objectToYmlString(Object object){
        JacksonYml jacksonYml = new JacksonYml()
        return jacksonYml.klassToString(object);
    }

}
