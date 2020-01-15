package com.hmtmcse.devops.plugin.shell;

import java.util.LinkedHashMap;
import java.util.List;

public class Shell {

    public String runFromPath;
    public LinkedHashMap<String, String> environmentVariable;
    public List<ShellCommand> commands;
    public ShellOption options = new ShellOption();

}
