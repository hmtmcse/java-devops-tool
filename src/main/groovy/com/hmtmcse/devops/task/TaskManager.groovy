package com.hmtmcse.devops.task

import com.hmtmcse.devops.report.StepBin
import com.hmtmcse.devops.task.action.Task

class TaskManager {

    public Boolean execute(Task task){}

    public Boolean executeFromJSON(String json){}

    public Boolean executeFromJSONFile(String location){}

    public StepBin getReport(){}
}
