package com.hmtmcse.devops.system.skeleton;

import java.util.LinkedHashMap;

public interface TaskInput<T> {
    public String getAction();
    public LinkedHashMap<String, String> getMessages();
    public void setAction(String action);
    public String getOperation();
    public void setOperation(String operation);
    public T getInput();
    public void setInput(T input);
}