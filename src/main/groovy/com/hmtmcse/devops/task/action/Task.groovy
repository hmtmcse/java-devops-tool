package com.hmtmcse.devops.task.action

class Task {

    public String name
    public Boolean failedContinue = false
    public Boolean showConsoleLog = false
    public Boolean showCommand = false
    public List<Action> actions
    public Map<String, String> inheritTask = [:]
}
