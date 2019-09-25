package com.hmtmcse.devops.task.executor

import com.hmtmcse.devops.report.Step
import com.hmtmcse.devops.task.action.Action
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.devops.task.model.TaskExecutor

class ShellCommandExecutor implements TaskExecutor<ShellCommandExecutor>, ExecutorCommonTask {

    @Override
    ShellCommandExecutor task(Task task) {
        return null
    }

    @Override
    Step execute(Action action) {
        return null
    }

    @Override
    Step shellExecute(Action action) {
        return null
    }

    @Override
    Step sudoExecute(Action action) {
        return null
    }

}
