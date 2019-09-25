package com.hmtmcse.devops.task.processor

import com.hmtmcse.devops.common.Config
import com.hmtmcse.devops.common.ConfigLoader
import com.hmtmcse.devops.common.DevOpsException
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.jtfutil.TextFileException
import com.hmtmcse.jtfutil.io.FDHelper
import com.hmtmcse.jtfutil.parser.YmlReader
import com.hmtmcse.jtfutil.text.ReadWriteTextFile
import com.hmtmcse.jtfutil.text.TextFileData

class InputToTask {

    public static final String JSON = "JSON"
    public static final String YML = "YML"

    private FDHelper fdHelper

    public InputToTask() {
        this.fdHelper = new FDHelper()
    }

    private Boolean isExist(String path) throws DevOpsException {
        if (fdHelper.isExist(path)) {
            return true
        }
        throw new DevOpsException('File not exist.')
    }

    public String getText(String location, Map<String, String> variables) throws TextFileException {
        ReadWriteTextFile readWriteTextFile = new ReadWriteTextFile()
        TextFileData textFileData = readWriteTextFile.readFileToString(location)
        if (variables && textFileData.text) {
            return readWriteTextFile.findAndReplaceInText(textFileData.text, readWriteTextFile.copyFromMap(variables))
        }
        return null
    }


    public Task loadTaskF(String type, String location, String varLoc, Config config) {
        Task task
        if (type.equals(YML)) {
            task = loadFromYMLFile(location, varLoc)
        } else {
            return null
        }
        task.config = loadConfig(config)
        return task
    }


    public Task loadTask(String type, String location, Map<String, String> variables = null, Config config = null) {
        Task task
        if (type.equals(YML)) {
            task = loadFromYMLFile(location, variables)
        } else {
            return null
        }
        task.config = loadConfig(config)
        return task
    }


    Config loadConfig(Config config) {
        if (config) {
            return config
        }
        return ConfigLoader.getConfig()
    }


    public Task loadFromYMLFile(String location, Map<String, String> variables) throws DevOpsException {
        if (isExist(location)) {
            try {
                YmlReader ymlReader = new YmlReader()
                Task task
                if (variables) {
                    String ymlContent = getText(location, variables)
                    task = ymlReader.ymlAsKlassByString(ymlContent, Task.class)
                } else {
                    task = ymlReader.ymlAsKlass(location, Task.class)
                }
                task.variables = variables
                return task
            } catch (Exception e) {
                throw new DevOpsException(e.getMessage())
            }
        }
    }


    public Task loadFromYMLFile(String location, String variableLoc) throws DevOpsException {
        if (isExist(location)) {
            try {
                YmlReader ymlReader = new YmlReader()
                Map<String, String> variables = null
                if (variableLoc && isExist(variableLoc)) {
                    variables = ymlReader.ymlAsMap(variableLoc)
                }
                return loadFromYMLFile(location, variables)
            } catch (Exception e) {
                throw new DevOpsException(e.getMessage())
            }
        }
    }

}
