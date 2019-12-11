package com.hmtmcse.devops.plugin.mkdir;

import com.hmtmcse.devops.data.TaskProgress;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;

public class MakeDirDefinition implements PluginDefinition {

    public static final String action = "makeDir";

    @Override
    public TaskReport executeTask(TaskInput taskInput) {
        return null;
    }

    @Override
    public void progress(TaskProgress taskProgress) {

    }

    @Override
    public Class<?> dataClass() {
        return MakeDirInput.class;
    }

    @Override
    public TaskInput dataFullExample() {
        MakeDirInput input = new MakeDirInput();
        input.action = action;
        input.operation = "Example Make Directory Operation.";
        MakeDir makeDir = new MakeDir();
        makeDir.setPath("/this/is/path");
        makeDir.setAllDefaultOption();
        input.input = makeDir;
        return input;
    }
}