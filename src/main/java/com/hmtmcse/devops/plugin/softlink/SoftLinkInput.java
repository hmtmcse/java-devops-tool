package com.hmtmcse.devops.plugin.softlink;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class SoftLinkInput implements TaskInput<SoftLink> {

    public String action;
    public String operation;
    public SoftLink input = new SoftLink();

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
    public SoftLink getInput() {
        return input;
    }

    @Override
    public void setInput(SoftLink input) {
        this.input = input;
    }
}
