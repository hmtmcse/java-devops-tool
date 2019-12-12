package com.hmtmcse.devops.plugin.copy;

import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class CopyDescriptor implements PluginDefinition<Copy> {

    public static final String action = "copy";

    @Override
    public TaskReport executeTask(TaskInput<Copy> taskInput) {
        System.out.println("Yes Buddy: CopyDescriptor");
        return null;
    }

    @Override
    public void progress(TaskProgress taskProgress) {
        System.out.println("Yes Buddy: CopyDescriptor progress");
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
