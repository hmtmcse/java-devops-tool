package com.hmtmcse.devops.plugin.findreplace;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class FindReplaceInput implements TaskInput<FindReplace> {

    public String action;
    public String operation;
    public FindReplace input = new FindReplace();

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
    public FindReplace getInput() {
        return input;
    }

    @Override
    public void setInput(FindReplace input) {
        this.input = input;
    }
}
