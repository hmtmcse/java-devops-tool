package com.hmtmcse.devops.plugin.softlink;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;

public class SoftLinkDescriptor implements PluginDefinition<SoftLink> {

    public static final String action = "softLink";


    @Override
    public TaskReport executeTask(TaskInput<SoftLink> taskInput, TaskProgress taskProgress) throws DevOpsException {
        System.out.println("Yes Buddy: SoftLinkDescriptor");
        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;
        return taskReport;
    }

    @Override
    public Class<?> dataClass() {
        return SoftLinkInput.class;
    }

    @Override
    public TaskInput<SoftLink> dataFullExample() {
        SoftLinkInput input = new SoftLinkInput();
        input.action = SoftLinkDescriptor.action;
        input.operation = "Example of SoftLink Plugin.";
        return input;
    }
}
