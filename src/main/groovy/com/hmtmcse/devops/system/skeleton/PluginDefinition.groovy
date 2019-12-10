package com.hmtmcse.devops.system.skeleton

import com.hmtmcse.devops.system.data.TaskProgress
import com.hmtmcse.devops.system.data.TaskReport


trait PluginDefinition {
    public abstract TaskReport executeTask(TaskInput taskInput);
    public abstract void progress(TaskProgress taskProgress);
    public abstract Class<?> dataClass();
    public abstract TaskInput dataFullExample();
}