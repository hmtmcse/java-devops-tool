package com.hmtmcse.devops.task.executor

import com.hmtmcse.devops.report.Step
import com.hmtmcse.devops.task.action.Action
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.devops.task.model.TaskExecutor

class LinuxOperatorExecutor implements TaskExecutor<LinuxOperatorExecutor>, ExecutorCommonTask {

    @Override
    LinuxOperatorExecutor task(Task task) {

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
