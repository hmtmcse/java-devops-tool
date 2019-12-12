package com.hmtmcse.devops.plugin.shell;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class ShellInput implements TaskInput<Shell> {

    public String action;
    public String operation;
    public Shell input = new Shell();

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getOperation() {
        return operation;
    }

    @Override
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public Shell getInput() {
        return input;
    }

    @Override
    public void setInput(Shell input) {
        this.input = input;
    }
}
