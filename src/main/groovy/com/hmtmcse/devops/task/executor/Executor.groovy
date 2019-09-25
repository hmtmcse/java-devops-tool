package com.hmtmcse.devops.task.executor

import com.hmtmcse.devops.report.Step
import com.hmtmcse.devops.report.StepBin
import com.hmtmcse.devops.task.action.Action
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.devops.task.model.TaskExecutor

class Executor {

    public void executeTask(Task task) {
        StepBin stepBin = new StepBin()
        Step step
        if (task) {
            task.actions.each { Action action ->
                step = executeAction(action, task)
                if (step) {
                    stepBin.addStep(step)
                }
            }
        }
    }


    private Step executeAction(Action action, Task task) {
        TaskExecutor taskExecutor = ExecutorBuilder.taskExecutor(action)
    }


}
