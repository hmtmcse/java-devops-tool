package com.hmtmcse.devops.plugin.archive;

import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class ArchiveDescriptor implements PluginDefinition<Archive> {

    public static final String action = "archive";

    @Override
    public TaskReport executeTask(TaskInput<Archive> taskInput) {
        System.out.println("Yes Buddy: ArchiveDescriptor");
        return null;
    }

    @Override
    public void progress(TaskProgress taskProgress) {
        System.out.println("Yes Buddy: ArchiveDescriptor progress");
    }

    @Override
    public Class<?> dataClass() {
        return ArchiveInput.class;
    }

    @Override
    public TaskInput<Archive> dataFullExample() {
        ArchiveInput input = new ArchiveInput();
        input.action = ArchiveDescriptor.action;
        input.operation = "Example of Archive Plugin.";
        return input;
    }
}
