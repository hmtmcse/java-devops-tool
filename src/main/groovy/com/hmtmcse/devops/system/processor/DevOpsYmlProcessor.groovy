package com.hmtmcse.devops.system.processor

import com.hmtmcse.devops.data.TaskDescriptor
import com.hmtmcse.devops.data.TaskVariable
import com.hmtmcse.jtfutil.text.ReadWriteTextFile
import com.hmtmcse.jtfutil.text.TextFileData
import com.hmtmcse.parser4java.YamlProcessor
import com.hmtmcse.parser4java.common.Parser4JavaException


class DevOpsYmlProcessor {

    private YamlProcessor yamlProcessor

    public DevOpsYmlProcessor() {
        yamlProcessor = new YamlProcessor()
    }


    public String objectToYmlString(Object object) throws Parser4JavaException {
        return yamlProcessor.klassToString(object);
    }

    public TaskVariable ymlFileToVariable(String location) throws Parser4JavaException {
        return yamlProcessor.ymlAsNestedKlass(location, TaskVariable.class)
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


    public TaskDescriptor ymlFileToObject(String location, Map<String, String> keywords = [:]) throws Parser4JavaException {
        String content = findReplaceKeyword(location, keywords)
        return yamlProcessor.ymlAsNestedKlassFromString(content, TaskDescriptor.class)
    }

}
