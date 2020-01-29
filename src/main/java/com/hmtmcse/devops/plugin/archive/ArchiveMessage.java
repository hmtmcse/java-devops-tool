package com.hmtmcse.devops.plugin.archive;

import com.hmtmcse.devops.data.common.DefaultMessage;

import java.util.LinkedHashMap;

public class ArchiveMessage implements DefaultMessage {

    public LinkedHashMap<String, String> messages = new LinkedHashMap<>();

    public ArchiveMessage() {
        messages.put(ArchiveConstant.EMPTY_ACTION, "Invalid source");
    }

    public static ArchiveMessage instance() {
        return new ArchiveMessage();
    }

    @Override
    public LinkedHashMap<String, String> messages() {
        return this.messages;
    }
}
