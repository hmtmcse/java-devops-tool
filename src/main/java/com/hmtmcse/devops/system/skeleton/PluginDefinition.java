package com.hmtmcse.devops.system.skeleton;


import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;

public interface PluginDefinition<T> {
    public TaskReport executeTask(TaskInput<T> taskInput, TaskProgress taskProgress) throws DevOpsException;
    public Class<?> dataClass();
    public TaskInput<T> dataFullExample();
}