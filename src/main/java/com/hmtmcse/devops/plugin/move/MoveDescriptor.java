package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.common.MessageHelper;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;
import com.hmtmcse.fileutil.common.FileUtilException;
import com.hmtmcse.fileutil.data.JDCopyOption;
import com.hmtmcse.fileutil.fd.FileDirectory;
import java.util.ArrayList;
import java.util.List;

public class MoveDescriptor implements PluginDefinition<Move> {

    public static final String action = "move";


    @Override
    public TaskReport executeTask(TaskInput<Move> taskInput, TaskProgress taskProgress) throws DevOpsException {
        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;
        Move input = taskInput.getInput();
        MoveOption moveOption = input.options;
        FileDirectory fileDirectory = new FileDirectory();
        MessageHelper messageHelper = new MessageHelper(new MoveMessage(), taskInput.getMessages());

        if (input.source == null || !fileDirectory.isExist(input.source)) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), messageHelper.getMessage(MoveConstant.INVALID_SOURCE));
            return taskReport;
        }

        if (input.target == null) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), messageHelper.getMessage(MoveConstant.INVALID_TARGET));
            return taskReport;
        }

        try {
            List<JDCopyOption> options = new ArrayList<>();
            if (moveOption != null) {
                if (moveOption.removeIfExist && fileDirectory.isExist(input.target)) {
                    fileDirectory.removeAll(input.target);
                }
                if (moveOption.replaceExisting) {
                    options.add(JDCopyOption.REPLACE_EXISTING);
                }
            }
            if (options.size() == 0) {
                fileDirectory.move(input.source, input.target);
            } else {
                fileDirectory.move(input.source, input.target, options.toArray(new JDCopyOption[0]));
            }
        } catch (FileUtilException e) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), e.getMessage());
            throw new DevOpsException(e.getMessage()).setTaskReport(taskReport);
        }
        return taskReport;
    }

    @Override
    public Class<?> dataClass() {
        return MoveInput.class;
    }

    @Override
    public TaskInput<Move> dataFullExample() {
        MoveInput input = new MoveInput();
        input.action = MoveDescriptor.action;
        input.operation = "Example of Move Plugin.";
        input.input.target = "/target/location";
        input.input.source = "/source/location";
        return input;
    }
}
