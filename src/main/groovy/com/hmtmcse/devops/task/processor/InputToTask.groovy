package com.hmtmcse.devops.task.processor

import com.hmtmcse.devops.common.DevOpsException
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.jtfutil.io.FDHelper
import com.hmtmcse.jtfutil.parser.JsonReadWrite
import com.hmtmcse.jtfutil.parser.YmlReader

class InputToTask {

    private FDHelper fdHelper

    public InputToTask(){
        this.fdHelper = new FDHelper()
    }

    private Boolean isExist(String path) throws DevOpsException {
        if (fdHelper.isExist(path)){
            return true
        }
        throw new DevOpsException('File not exist.')
    }


    public Task executeFromYMLFile(String location, String variableLoc) throws DevOpsException {
        if (isExist(location)){
            try {
                YmlReader ymlReader = new YmlReader()
                Task task = ymlReader.ymlAsKlass(location, Task.class)
                if (variableLoc && isExist(variableLoc)){
                    task.variables = ymlReader.ymlAsMap(variableLoc)
                }else{
                    task.variables = null
                }
                return task
            }catch(Exception e){
                throw new DevOpsException(e.getMessage())
            }
        }
    }


    public Task executeFromYMLFile(String location) throws DevOpsException {
        return executeFromYMLFile(location, null)
    }



    public Task executeFromJSONFile(String location) throws DevOpsException {
        return executeFromJSONFile(location, null)
    }


    public Task executeFromJSONFile(String location, String variableLoc) throws DevOpsException {
        if (isExist(location)){
            try {
                JsonReadWrite jsonReadWrite = new JsonReadWrite()
                Task task = jsonReadWrite.readJsonFileAsKlass(location, Task.class)
                if (variableLoc && isExist(variableLoc)){
                    task.variables = jsonReadWrite.readJsonFileToMap(variableLoc)
                }else{
                    task.variables = null
                }
                return task
            }catch(Exception e){
                throw new DevOpsException(e.getMessage())
            }
        }
    }

}
