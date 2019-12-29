package com.hmtmcse.devops.plugin.mkdir;

import com.hmtmcse.devops.system.skeleton.TaskInput;

import java.util.LinkedHashMap;

public class MakeDirInput implements TaskInput<MakeDir> {

    public String action;
    public String operation;
    public MakeDir input;
    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    @Override
    public String getAction() {
        return this.action;
    }

    @Override
    public LinkedHashMap<String, String> getMessages() {
        return this.messages;
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