package com.hmtmcse.devops.task.action

import com.hmtmcse.devops.common.Config
import com.hmtmcse.devops.task.model.TaskListener

class Task {

    public Config config
    public String name
    public List<Action> actions
    public Map<String, String> inheritTask = [:]
    public Map<String, Object> variables = [:]
    public TaskListener taskListener = null
}
