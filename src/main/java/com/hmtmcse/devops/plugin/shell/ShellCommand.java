package com.hmtmcse.devops.plugin.shell;

import java.util.ArrayList;
import java.util.List;

public class ShellCommand {

    public String name;
    public String command;
    public List<String> loop;
    private String loopItem = "__loopItem";

    public ShellCommand() {}

    public ShellCommand(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public ShellCommand addLoopItem(String loopItem){
        if (this.loop == null){
            this.loop = new ArrayList<>();
        }
        this.loop.add(loopItem);
        return this;
    }

    public ShellCommand replace(String data){
        this.name = findReplace(this.name, data);
        this.command = findReplace(this.command, data);
        return this;
    }

    private String findReplace(String find, String replace) {
        if (find != null) {
            find = find.replaceAll(this.loopItem, replace);
        }
        return find;
    }
}
