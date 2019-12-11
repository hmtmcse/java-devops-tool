package com.hmtmcse.devops.system.skeleton;


import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;

public interface PluginDefinition {
    public TaskReport executeTask(TaskInput taskInput);
    public void progress(TaskProgress taskProgress);
    public Class<?> dataClass();
    public TaskInput dataFullExample();
}