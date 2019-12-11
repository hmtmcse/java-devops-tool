package com.hmtmcse.devops.plugin.plugin;

import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class DPluginDescriptor implements PluginDefinition<BPlugin> {

    public static final String action = "plugin";

    @Override
    public TaskReport executeTask(TaskInput<BPlugin> taskInput) {
        System.out.println("Yes Buddy: DPluginDescriptor");
        return null;
    }

    @Override
    public void progress(TaskProgress taskProgress) {
        System.out.println("Yes Buddy: DPluginDescriptor progress");
    }

    @Override
    public Class<?> dataClass() {
        return CPluginInput.class;
    }

    @Override
    public TaskInput<BPlugin> dataFullExample() {
        return new CPluginInput();
    }
}
