package com.hmtmcse.devops.plugin.shell;

import com.hmtmcse.devops.data.common.DefaultMessage;

import java.util.LinkedHashMap;

public class ShellMessage implements DefaultMessage {

    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    public ShellMessage(){
        messages.put(ShellConstant.TASK_NAME, "Task");
        messages.put(ShellConstant.EMPTY_ACTION, "Invalid Command");
    }

    public static ShellMessage instance(){
        return new ShellMessage();
    }

    @Override
    public LinkedHashMap<String, String> messages() {
        return this.messages;
    }
}
