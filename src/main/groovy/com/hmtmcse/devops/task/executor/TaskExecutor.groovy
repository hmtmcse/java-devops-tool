package com.hmtmcse.devops.task.executor

import com.hmtmcse.devops.report.Step
import com.hmtmcse.devops.task.action.Action

interface TaskExecutor {

    public Step execute(Action action);

}