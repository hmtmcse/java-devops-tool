package com.hmtmcse.devops.task.model

import com.hmtmcse.devops.report.Step
import com.hmtmcse.devops.task.action.Action
import com.hmtmcse.devops.task.action.Task

interface TaskExecutor<T> {

    public T task(Task task)
    public Step execute(Action action);
    public Step shellExecute(Action action);
    public Step sudoExecute(Action action);
}