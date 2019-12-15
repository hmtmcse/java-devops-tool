package com.hmtmcse.devops.plugin.remove;


import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;

public class RemoveDefinition implements PluginDefinition<Remove> {

    public static final String action = "remove";


    @Override
    public TaskReport executeTask(TaskInput<Remove> taskInput, TaskProgress taskProgress) throws DevOpsException {
        System.out.println("Yes Buddy: RemoveDefinition");
        return null;
    }

    @Override
    public Class<?> dataClass() {
        return RemoveInput.class;
    }

    @Override
    public TaskInput<Remove> dataFullExample() {
        RemoveInput removeInput = new RemoveInput();
        removeInput.operation = "Example of Remove";
        removeInput.input.path = "/this/is/the/path";
        return removeInput;
    }

}
