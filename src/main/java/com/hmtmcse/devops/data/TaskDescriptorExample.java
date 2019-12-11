package com.hmtmcse.devops.data;

import com.hmtmcse.devops.system.skeleton.TaskInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaskDescriptorExample extends TaskDescriptorBase{

    public String taskName;
    public List<TaskInput> actions = new ArrayList<>();

}
