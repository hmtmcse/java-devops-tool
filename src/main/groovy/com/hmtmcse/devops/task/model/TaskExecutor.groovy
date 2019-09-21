package com.hmtmcse.devops.task.model

import com.hmtmcse.devops.report.Step
import com.hmtmcse.devops.task.action.Action

interface TaskExecutor {
    public Step execute(Action action);
    public Step shellExecute(Action action);
    public Step sudoExecute(Action action);
}