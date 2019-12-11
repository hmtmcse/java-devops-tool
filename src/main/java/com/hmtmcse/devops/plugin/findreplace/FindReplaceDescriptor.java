package com.hmtmcse.devops.plugin.findreplace;

import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class FindReplaceDescriptor implements PluginDefinition<FindReplace> {

    public static final String action = "fiendReplace";

    @Override
    public TaskReport executeTask(TaskInput<FindReplace> taskInput) {
        System.out.println("Yes Buddy: FindReplaceDescriptor");
        return null;
    }

    @Override
    public void progress(TaskProgress taskProgress) {
        System.out.println("Yes Buddy: FindReplaceDescriptor progress");
    }

    @Override
    public Class<?> dataClass() {
        return FindReplaceInput.class;
    }

    @Override
    public TaskInput<FindReplace> dataFullExample() {
        return new FindReplaceInput();
    }
}
