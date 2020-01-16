package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.data.common.DefaultMessage;
import java.util.LinkedHashMap;


public class MoveMessage implements DefaultMessage {

    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    public MoveMessage(){
        messages.put(MoveConstant.INVALID_INPUT, "Invalid or Null input");
    }

    public static MoveMessage instance(){
        return new MoveMessage();
    }

    @Override
    public LinkedHashMap<String, String> messages() {
        return this.messages;
    }
}
