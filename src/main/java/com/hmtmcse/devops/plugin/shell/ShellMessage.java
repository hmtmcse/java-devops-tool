package com.hmtmcse.devops.plugin.shell;

import java.util.LinkedHashMap;

public class ShellMessage {

    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    public ShellMessage(){
        messages.put(ShellConstant.TASK_NAME, "Task");
        messages.put(ShellConstant.EMPTY_ACTION, "Invalid Command");
    }

    public static ShellMessage instance(){
        return new ShellMessage();
    }
}
