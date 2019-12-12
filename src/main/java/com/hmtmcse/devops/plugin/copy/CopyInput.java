package com.hmtmcse.devops.plugin.copy;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class CopyInput implements TaskInput<Copy> {

    public String action;
    public String operation;
    public Copy input = new Copy();

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
    public Copy getInput() {
        return input;
    }

    @Override
    public void setInput(Copy input) {
        this.input = input;
    }
}
