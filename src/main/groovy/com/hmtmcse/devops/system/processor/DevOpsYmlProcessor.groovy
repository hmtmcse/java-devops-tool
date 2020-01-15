package com.hmtmcse.devops.system.processor

import com.hmtmcse.devops.data.TaskDescriptor
import com.hmtmcse.devops.data.TaskVariable
import com.hmtmcse.jtfutil.parser.JacksonYml
import com.hmtmcse.jtfutil.text.ReadWriteTextFile
import com.hmtmcse.jtfutil.text.TextFileData
import com.hmtmcse.parser4java.YamlProcessor

class DevOpsYmlProcessor {


    public String objectToYmlString(Object object){
        YamlProcessor jacksonYml = new YamlProcessor()
        return jacksonYml.klassToString(object);
    }

    public TaskVariable ymlFileToVariable(String location) {
        JacksonYml jacksonYml = new JacksonYml()
        return jacksonYml.ymlAsNestedKlass(location, TaskVariable.class)
    }

    public String findReplaceKeyword(String location, Map<String, String> keywords = [:]) {
        ReadWriteTextFile readWriteTextFile = new ReadWriteTextFile();
        TextFileData textFileData = readWriteTextFile.readFileToString(location)
        String content = null
        if (textFileData.getText()) {
            content = textFileData.getText()
            keywords.each { String key, String value ->
                content = content.replaceAll(key, value);
            }
        }
        return content
    }

    public TaskDescriptor ymlFileToObject(String location, Map<String, String> keywords = [:]) {
        String content = findReplaceKeyword(location, keywords)
        JacksonYml jacksonYml = new JacksonYml()
        return jacksonYml.ymlAsNestedKlassFromString(content, TaskDescriptor.class)
    }

}
