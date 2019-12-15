package com.hmtmcse.devops.plugin.mkdir;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;
import com.hmtmcse.devops.system.common.DevOpsException;

public class MakeDirDefinition implements PluginDefinition<MakeDir> {

    public static final String action = "makeDir";

    @Override
    public TaskReport executeTask(TaskInput<MakeDir> taskInput, TaskProgress taskProgress) throws DevOpsException {
        taskProgress.errorThrowException("Not working");
        return null;
    }

    @Override
    public Class<?> dataClass() {
        return MakeDirInput.class;
    }

    @Override
    public TaskInput<MakeDir> dataFullExample() {
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