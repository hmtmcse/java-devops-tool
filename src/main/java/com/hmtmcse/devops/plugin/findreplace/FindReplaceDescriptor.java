package com.hmtmcse.devops.plugin.findreplace;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;

public class FindReplaceDescriptor implements PluginDefinition<FindReplace> {

    public static final String action = "findReplace";

    @Override
    public TaskReport executeTask(TaskInput<FindReplace> taskInput, TaskProgress taskProgress) throws DevOpsException {
        System.out.println("Yes Buddy: FindReplaceDescriptor");
        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;
        return taskReport;
    }

    @Override
    public Class<?> dataClass() {
        return FindReplaceInput.class;
    }

    @Override
    public TaskInput<FindReplace> dataFullExample() {
        FindReplaceInput input = new FindReplaceInput();
        input.action = FindReplaceDescriptor.action;
        input.operation = "Example of FindReplace Plugin.";
        return input;
    }
}
