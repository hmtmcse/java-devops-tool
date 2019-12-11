package com.hmtmcse.devops.plugin.plugin;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class CPluginInput implements TaskInput<BPlugin> {

    public String action;
    public String operation;
    public BPlugin input;

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
    public BPlugin getInput() {
        return input;
    }

    @Override
    public void setInput(BPlugin input) {
        this.input = input;
    }
}
