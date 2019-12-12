package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.system.skeleton.TaskInput;

public class MoveInput implements TaskInput<Move> {

    public String action;
    public String operation;
    public Move input = new Move();

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
    public Move getInput() {
        return input;
    }

    @Override
    public void setInput(Move input) {
        this.input = input;
    }
}
