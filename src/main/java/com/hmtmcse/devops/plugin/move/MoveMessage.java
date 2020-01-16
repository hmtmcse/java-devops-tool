package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.data.common.DefaultMessage;
import java.util.LinkedHashMap;


public class MoveMessage implements DefaultMessage {

    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    public MoveMessage(){
        messages.put(MoveConstant.INVALID_SOURCE, "Invalid or Null Source");
        messages.put(MoveConstant.INVALID_TARGET, "Invalid or Null Target");
    }

    public static MoveMessage instance(){
        return new MoveMessage();
    }

    @Override
    public LinkedHashMap<String, String> messages() {
        return this.messages;
    }
}
