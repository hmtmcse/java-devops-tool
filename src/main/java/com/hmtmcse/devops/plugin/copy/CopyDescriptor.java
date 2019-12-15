package com.hmtmcse.devops.plugin.copy;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;

public class CopyDescriptor implements PluginDefinition<Copy> {

    public static final String action = "copy";

    @Override
    public TaskReport executeTask(TaskInput<Copy> taskInput, TaskProgress taskProgress) throws DevOpsException {
        System.out.println("Yes Buddy: CopyDescriptor");
        return null;
    }

    @Override
    public Class<?> dataClass() {
        return CopyInput.class;
    }

    @Override
    public TaskInput<Copy> dataFullExample() {
        CopyInput input = new CopyInput();
        input.action = CopyDescriptor.action;
        input.operation = "Example of Copy Plugin.";
        return input;
    }
}
