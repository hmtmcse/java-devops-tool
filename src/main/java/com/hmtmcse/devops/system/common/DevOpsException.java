package com.hmtmcse.devops.system.common;

import com.hmtmcse.devops.data.TaskReport;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class DevOpsException extends Exception {

    public TaskReport taskReport;

    public DevOpsException(){
        super("DevOps Exception Occurred!");
    }

    public DevOpsException(String message){
        super(message);
    }

    public DevOpsException setTaskReport(TaskReport taskReport){
        this.taskReport = taskReport;
        return this;
    }
}
