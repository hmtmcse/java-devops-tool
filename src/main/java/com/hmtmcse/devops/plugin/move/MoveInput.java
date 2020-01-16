package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.system.skeleton.TaskInput;

import java.util.LinkedHashMap;

public class MoveInput implements TaskInput<Move> {

    public String action;
    public String operation;
    public Move input = new Move();
    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();


    public MoveInput() {
        this.messages = MoveMessage.instance().messages;
    }

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
    public Move getInput() {
        return input;
    }

    @Override
    public void setInput(Move input) {
        this.input = input;
    }
}
