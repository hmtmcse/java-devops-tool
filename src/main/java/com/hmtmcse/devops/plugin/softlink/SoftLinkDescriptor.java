package com.hmtmcse.devops.plugin.softlink;

import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class SoftLinkDescriptor implements PluginDefinition<SoftLink> {

    public static final String action = "softLink";

    @Override
    public TaskReport executeTask(TaskInput<SoftLink> taskInput) {
        System.out.println("Yes Buddy: SoftLinkDescriptor");
        return null;
    }

    @Override
    public void progress(TaskProgress taskProgress) {
        System.out.println("Yes Buddy: SoftLinkDescriptor progress");
    }

    @Override
    public Class<?> dataClass() {
        return SoftLinkInput.class;
    }

    @Override
    public TaskInput<SoftLink> dataFullExample() {
        SoftLinkInput input = new SoftLinkInput();
        input.action = SoftLinkDescriptor.action;
        input.operation = "Example of SoftLink Plugin.";
        return input;
    }
}
