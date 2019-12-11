package com.hmtmcse.devops.system.skeleton;

public interface TaskInput<T> {
    public String getAction();
    public void setAction(String action);
    public String getOperation();
    public void setOperation(String operation);
    public T getInput();
    public void setInput(T input);
}