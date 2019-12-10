package com.hmtmcse.devops.system.skeleton

trait TaskInput <T> {
    public abstract String getAction();
    public abstract void setAction(String action);
    public abstract String getOperation();
    public abstract void setOperation(String operation);
    public abstract T getInput();
    public abstract void setInput(T input);
}