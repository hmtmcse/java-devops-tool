package com.hmtmcse.devops.plugin.remove;


import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class RemoveDefinition implements PluginDefinition {

    public static final String action = "remove";


    @Override
    public TaskReport executeTask(TaskInput taskInput) {
        return null;
    }

    @Override
    public Class<?> dataClass() {
        return null;
    }

    @Override
    public TaskInput dataFullExample() {
        return new RemoveInput();
    }

    @Override
    public void progress(TaskProgress taskProgress) {

    }
}
