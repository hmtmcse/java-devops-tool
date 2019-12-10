package com.hmtmcse.devops.plugin.mkdir

import com.hmtmcse.devops.system.skeleton.TaskInput


class MakeDirInput implements TaskInput<MakeDirInput> {

    public String action
    public String operation
    public MakeDirInput input

    @Override
    String getAction() {
        return this.action
    }

    @Override
    void setAction(String action) {
        this.action = this
    }

    @Override
    String getOperation() {
        return this.operation
    }

    @Override
    void setOperation(String operation) {
        this.operation = operation
    }

    @Override
    MakeDirInput getInput() {
        return this.input
    }

    @Override
    void setInput(MakeDirInput input) {
        this.input = input
    }

}
