package com.hmtmcse.devops.data;

import java.util.ArrayList;
import java.util.List;

public class TaskReport {

    public Status status;
    public String action;
    public String operation;
    public String error;
    public String message;
    public List<TaskReport> nestedTaskReport = new ArrayList<>();
    private Integer tmpIndex;

    public TaskReport success(String action, String operation){
        return this.success(action, operation, null);
    }

    public TaskReport success(String action, String operation, String message){
        this.status = Status.SUCCESS;
        this.action = action;
        this.operation = operation;
        this.message = message;
        return this;
    }

    public TaskReport failed(String action, String operation, String error){
        this.status = Status.FAILED;
        this.action = action;
        this.operation = operation;
        this.error = error;
        return this;
    }

    public TaskReport partialSuccess(String action, String operation, String error){
        this.status = Status.PARTIALLY_SUCCESS;
        this.action = action;
        this.operation = operation;
        this.error = error;
        return this;
    }

    public TaskReport nested() {
        TaskReport taskReport = new TaskReport();
        nestedTaskReport.add(taskReport);
        tmpIndex = nestedTaskReport.indexOf(taskReport);
        return nestedTaskReport.get(tmpIndex);
    }

}
