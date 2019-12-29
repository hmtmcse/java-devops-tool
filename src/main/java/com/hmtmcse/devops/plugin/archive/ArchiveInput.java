package com.hmtmcse.devops.plugin.archive;

import com.hmtmcse.devops.system.skeleton.TaskInput;

import java.util.LinkedHashMap;

public class ArchiveInput implements TaskInput<Archive> {

    public String action;
    public String operation;
    public Archive input = new Archive();
    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    @Override
    public String getAction() {
        return action;
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
        return operation;
    }

    @Override
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public Archive getInput() {
        return input;
    }

    @Override
    public void setInput(Archive input) {
        this.input = input;
    }
}
