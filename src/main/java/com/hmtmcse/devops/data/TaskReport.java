package com.hmtmcse.devops.data;

import java.util.ArrayList;
import java.util.List;

public class TaskReport {

    public Status status;
    public String action;
    public String operation;
    List<TaskReport> nestedTaskReport = new ArrayList<>();

}
