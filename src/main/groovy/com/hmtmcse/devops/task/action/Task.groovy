package com.hmtmcse.devops.task.action

class Task {

    public String name
    public Boolean linuxSudo = false
    public List<Action> actions
    public Map<String, String> inheritTask = [:]
}
