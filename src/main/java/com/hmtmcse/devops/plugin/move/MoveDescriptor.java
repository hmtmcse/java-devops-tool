package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class MoveDescriptor implements PluginDefinition<Move> {

    public static final String action = "move";

    @Override
    public TaskReport executeTask(TaskInput<Move> taskInput) {
        System.out.println("Yes Buddy: MoveDescriptor");
        return null;
    }

    @Override
    public void progress(TaskProgress taskProgress) {
        System.out.println("Yes Buddy: MoveDescriptor progress");
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
