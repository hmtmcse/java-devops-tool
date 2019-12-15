package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;

public class MoveDescriptor implements PluginDefinition<Move> {

    public static final String action = "move";


    @Override
    public TaskReport executeTask(TaskInput<Move> taskInput, TaskProgress taskProgress) throws DevOpsException {
        System.out.println("Yes Buddy: MoveDescriptor");
        return null;
    }

    @Override
    public Class<?> dataClass() {
        return MoveInput.class;
    }

    @Override
    public TaskInput<Move> dataFullExample() {
        MoveInput input = new MoveInput();
        input.action = MoveDescriptor.action;
        input.operation = "Example of Move Plugin.";
        return input;
    }
}
