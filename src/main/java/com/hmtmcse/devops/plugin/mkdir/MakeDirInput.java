package com.hmtmcse.devops.plugin.mkdir;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class MakeDirInput implements TaskInput<MakeDir> {

    public String action;
    public String operation;
    public MakeDir input;

    @Override
    public String getAction() {
        return this.action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getOperation() {
        return this.operation;
    }

    @Override
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public MakeDir getInput() {
        return this.input;
    }

    @Override
    public void setInput(MakeDir input) {
        this.input = input;
    }

}