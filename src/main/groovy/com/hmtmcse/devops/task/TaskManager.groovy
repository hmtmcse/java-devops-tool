package com.hmtmcse.devops.task

import com.hmtmcse.devops.common.Config
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.devops.task.executor.Executor
import com.hmtmcse.devops.task.processor.InputToTask

class TaskManager {

    private InputToTask inputToTask
    private Executor executor

    public TaskManager(){
        this.inputToTask = new InputToTask()
        this.executor = new Executor()
    }


    public Boolean execute(String type, String location, Map<String, String> variables = null, Config config = null){
        Task task = inputToTask.loadTask(type, location, variables, config)
        return executor.executeTask(task)
    }


    public Boolean executeF(String type, String location, String variables = null, Config config = null){
        Task task = inputToTask.loadTaskF(type, location, variables, config)
        return executor.executeTask(task)
    }



    public Boolean executeFromJSON(String location){
        return executeF(InputToTask.JSON, location)
    }

    public Boolean executeFromJSON(String location, String variableLoc){
        return executeF(InputToTask.JSON, location, variableLoc)
    }

    public Boolean executeFromYML(String location){
        return executeF(InputToTask.YML, location)
    }

    public Boolean executeFromYML(String location, String variableLoc){
        return executeF(InputToTask.YML, location, variableLoc)
    }


}
