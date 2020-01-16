package com.hmtmcse.devops.plugin.copy;

import com.hmtmcse.devops.data.common.DefaultMessage;
import java.util.LinkedHashMap;


public class CopyMessage implements DefaultMessage {

    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    public CopyMessage(){
        messages.put(CopyConstant.INVALID_INPUT, "Invalid or Null input");
    }

    public static CopyMessage instance(){
        return new CopyMessage();
    }

    @Override
    public LinkedHashMap<String, String> messages() {
        return this.messages;
    }
}
