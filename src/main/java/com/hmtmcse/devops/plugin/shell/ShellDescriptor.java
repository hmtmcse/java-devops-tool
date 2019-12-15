package com.hmtmcse.devops.plugin.shell;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;

public class ShellDescriptor implements PluginDefinition<Shell> {

    public static final String action = "shell";

    @Override
    public TaskReport executeTask(TaskInput<Shell> taskInput, TaskProgress taskProgress) throws DevOpsException {
        System.out.println("Yes Buddy: ShellDescriptor");
        return null;
    }


    @Override
    public Class<?> dataClass() {
        return ShellInput.class;
    }

    @Override
    public TaskInput<Shell> dataFullExample() {
        ShellInput input = new ShellInput();
        input.action = ShellDescriptor.action;
        input.operation = "Example of Shell Plugin.";
        return input;
    }
}
