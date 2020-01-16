package com.hmtmcse.devops.plugin.shell;

import com.hmtmcse.common.util.TMUtil;
import com.hmtmcse.devops.common.MessageHelper;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;
import com.hmtmcse.shellutil.base.CmdOutputLineCallBack;
import com.hmtmcse.shellutil.base.CommandRequest;
import com.hmtmcse.shellutil.base.CommandResponse;
import com.hmtmcse.shellutil.base.OSCommandExec;
import java.util.ArrayList;


public class ShellDescriptor implements PluginDefinition<Shell> {

    public static final String action = "shell";
    public Integer index = 1;

    @Override
    public TaskReport executeTask(TaskInput<Shell> taskInput, TaskProgress taskProgress) throws DevOpsException {

        OSCommandExec osCommandExec = new OSCommandExec();
        CommandResponse commandResponse = null;
        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;

        Shell shellInput = taskInput.getInput();
        ShellOption options = shellInput.options;
        CommandRequest commandRequest = new CommandRequest();
        if (shellInput.runFromPath != null) {
            commandRequest.setCommandHome(shellInput.runFromPath);
        }

        commandRequest.cmdOutputLineCallBack = new CmdOutputLineCallBack() {
            @Override
            public void eachLine(String line, OSCommandExec osCommandExec) {
                taskProgress.message(line);
            }
        };

        commandRequest.setPrintInConsole(options.isPrintInConsole);
        commandRequest.setWaitUntilFinish(true);
        String message;
        MessageHelper messageHelper = new MessageHelper(new ShellMessage(), taskInput.getMessages());
        if (shellInput.commands != null) {
            taskReport.success(taskInput.getAction(), taskInput.getOperation());
            ShellCommand originalCommand;
            for (ShellCommand command : shellInput.commands) {
                if (command.command != null) {
                    if (command.loop == null) {
                        command.addLoopItem("_THIS_IS_VERY_DUMMY_DATA_" + TMUtil.randomInteger());
                    }

                    originalCommand = command.copy();
                    for (String loopItem : originalCommand.loop) {
                        command = originalCommand.copy();
                        command.replace(loopItem);
                        commandRequest.command = this.stringToArray(command.command);
                        if (commandRequest.command != null) {
                            commandResponse = osCommandExec.execute(commandRequest);
                            message = messageHelper.getMessageIfNull(ShellConstant.TASK_NAME, command.name, index);
                            if (commandResponse != null && commandResponse.isExecuted) {
                                taskReport.nested().success(taskInput.getAction(), message + ". Exit Code: " + commandResponse.exitCode);
                            } else {
                                message = message + ". Exit Code: " + commandResponse.exitCode + ". Command: " + command.command;
                                taskReport.nested().failed(taskInput.getAction(), message, commandResponse.exceptionMessage);
                            }
                        }
                        index++;
                    }
                }
            }
        } else {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), messageHelper.getMessage(ShellConstant.EMPTY_ACTION));
        }
        return taskReport;
    }



    private String[] stringToArray(String command) {
        if (command == null) {
            return null;
        }
        return command.split(" ");
    }

    @Override
    public Class<?> dataClass() {
        return ShellInput.class;
    }

    @Override
    public TaskInput<Shell> dataFullExample() {
        ShellInput input = new ShellInput();
        input.action = ShellDescriptor.action;
        input.operation = "Example of Shell Plugin.";
        input.input.commands = new ArrayList<>();
        input.input.commands.add(new ShellCommand("Ping HMTM Site", "ping hmtmcse.com"));
        return input;
    }
}
