package com.hmtmcse.devops.plugin.copy;

import com.hmtmcse.devops.system.skeleton.TaskInput;
import java.util.LinkedHashMap;

public class CopyInput implements TaskInput<Copy> {

    public String action;
    public String operation;
    public Copy input = new Copy();
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
    public Copy getInput() {
        return input;
    }

    @Override
    public void setInput(Copy input) {
        this.input = input;
    }
}
