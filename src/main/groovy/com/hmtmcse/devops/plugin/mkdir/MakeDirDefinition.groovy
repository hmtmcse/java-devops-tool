package com.hmtmcse.devops.plugin.mkdir

import com.hmtmcse.devops.system.data.TaskProgress
import com.hmtmcse.devops.system.data.TaskReport
import com.hmtmcse.devops.system.skeleton.PluginDefinition
import com.hmtmcse.devops.system.skeleton.TaskInput

class MakeDirDefinition implements PluginDefinition {

    public static final String action = "";

    @Override
    TaskReport executeTask(TaskInput taskInput) {
        return null
    }

    @Override
    void progress(TaskProgress taskProgress) {

    }

    @Override
    Class<?> dataClass() {
        return MakeDirInput.class
    }

    @Override
    TaskInput dataFullExample() {
        MakeDirInput input = new MakeDirInput()
        input.action = action
        input.operation = "Example Make Directory Operation."
        input.input = new MakeDir().setPath("/this/is/path").setDefaultOption()
        return null
    }
}
