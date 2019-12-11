package com.hmtmcse.devops.system.skeleton;


import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;

public interface PluginDefinition<T> {
    public TaskReport executeTask(TaskInput<T> taskInput);
    public void progress(TaskProgress taskProgress);
    public Class<?> dataClass();
    public TaskInput<T> dataFullExample();
}