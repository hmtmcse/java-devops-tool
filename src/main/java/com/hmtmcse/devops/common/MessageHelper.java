package com.hmtmcse.devops.common;

import com.hmtmcse.devops.data.common.DefaultMessage;
import com.hmtmcse.devops.plugin.shell.ShellMessage;

import java.util.LinkedHashMap;

public class MessageHelper {

    private DefaultMessage defaultMessage;
    private LinkedHashMap<String, String> providedMessage;

    public MessageHelper(DefaultMessage defaultMessage, LinkedHashMap<String, String> providedMessage){
        this.defaultMessage = defaultMessage;
        this.providedMessage = providedMessage;
    }

    public String getMessageIfNull(String key, String providedMessage){
        return this.getMessageIfNull(key, providedMessage, null);
    }

    public String getMessageIfNull(String key, String providedMessage, Integer index){
        if (providedMessage != null){
            return providedMessage;
        }
        return this.getMessage(key,  index);
    }


    public String getMessage(String key, Integer index) {
        if (providedMessage != null && providedMessage.get(key) != null) {
            return providedMessage.get(key);
        }
        if (defaultMessage.messages().get(key) != null) {
            return defaultMessage.messages().get(key) + (index != null ? " " + index : "");
        }
        return "No Message";
    }

    public String getMessage(String key) {
        return getMessage(key, null);
    }
}
