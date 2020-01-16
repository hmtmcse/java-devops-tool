package com.hmtmcse.devops.plugin.copy;

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

public class CopyDescriptor implements PluginDefinition<Copy> {

    public static final String action = "copy";

    @Override
    public TaskReport executeTask(TaskInput<Copy> taskInput, TaskProgress taskProgress) throws DevOpsException {
        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;
        Copy input = taskInput.getInput();
        CopyOption moveOption = input.options;
        FileDirectory fileDirectory = new FileDirectory();
        MessageHelper messageHelper = new MessageHelper(new CopyMessage(), taskInput.getMessages());

        if (input.source == null || !fileDirectory.isExist(input.source)) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), messageHelper.getMessage(CopyConstant.INVALID_SOURCE));
            return taskReport;
        }

        if (input.target == null) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), messageHelper.getMessage(CopyConstant.INVALID_TARGET));
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
                if (moveOption.noFollowLinks) {
                    options.add(JDCopyOption.NOFOLLOW_LINKS);
                }
                if (moveOption.copyAttributes) {
                    options.add(JDCopyOption.COPY_ATTRIBUTES);
                }
            }
            if (options.size() == 0) {
                fileDirectory.copyAll(input.source, input.target);
            } else {
                fileDirectory.copyAll(input.source, input.target, options.toArray(new JDCopyOption[0]));
            }
        } catch (FileUtilException e) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), e.getMessage());
            throw new DevOpsException(e.getMessage()).setTaskReport(taskReport);
        }
        return taskReport;
    }

    @Override
    public Class<?> dataClass() {
        return CopyInput.class;
    }

    @Override
    public TaskInput<Copy> dataFullExample() {
        CopyInput input = new CopyInput();
        input.action = CopyDescriptor.action;
        input.operation = "Example of Copy Plugin.";
        input.input.target = "/target/location";
        input.input.source = "/source/location";
        return input;
    }
}
