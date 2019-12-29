package com.hmtmcse.devops.plugin.remove;

import com.hmtmcse.devops.system.skeleton.TaskInput;

import java.util.LinkedHashMap;

public class RemoveInput implements TaskInput<Remove> {

    public String action = RemoveDefinition.action;
    public String operation;
    public Remove input = new Remove();
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
    public Remove getInput() {
        return input;
    }

    @Override
    public void setInput(Remove input) {
        this.input = input;
    }


}
