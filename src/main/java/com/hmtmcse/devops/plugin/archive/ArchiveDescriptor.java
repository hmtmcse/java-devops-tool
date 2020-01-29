package com.hmtmcse.devops.plugin.archive;

import com.hmtmcse.archive.ArchiveManager;
import com.hmtmcse.archive.common.ArchiveException;
import com.hmtmcse.devops.common.MessageHelper;
import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;
import com.hmtmcse.fileutil.common.FileUtilException;
import com.hmtmcse.fileutil.fd.FileDirectory;

public class ArchiveDescriptor implements PluginDefinition<Archive> {

    public static final String action = "archive";
    private MessageHelper messageHelper;

    @Override
    public TaskReport executeTask(TaskInput<Archive> taskInput, TaskProgress taskProgress) throws DevOpsException {
        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;

        messageHelper = new MessageHelper(new ArchiveMessage(), taskInput.getMessages());

        Archive archive = taskInput.getInput();
        FileDirectory fileDirectory = new FileDirectory();
        try {

            if (archive.options.ifOutputExistThenRemove && fileDirectory.isExist(archive.output)) {
                fileDirectory.removeAll(archive.output);
            }

            if (!fileDirectory.isExist(archive.source)) {
                throw new DevOpsException(messageHelper.getMessage(ArchiveConstant.EMPTY_ACTION));
            }

            ArchiveManager archiveManager = new ArchiveManager();
            archiveManager.setInputOutput(archive.source, archive.output);
            switch (archive.archiveAction) {
                case ArchiveConstant.create:
                    processCreate(archive, archiveManager);
                    break;
                case ArchiveConstant.extract:
                    processExtract(archive, archiveManager);
                    break;
            }

        } catch (FileUtilException | ArchiveException e) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), e.getMessage());
            throw new DevOpsException(e.getMessage()).setTaskReport(taskReport);
        }
        taskReport.success(taskInput.getAction(), taskInput.getOperation());
        return taskReport;
    }


    private void processCreate(Archive archive, ArchiveManager archiveManager) throws ArchiveException {
        switch (archive.type) {
            case ArchiveConstant.zip:
                archiveManager.zip();
                break;
            case ArchiveConstant.tar:
                archiveManager.tar();
                break;
        }
    }


    private void processExtract(Archive archive, ArchiveManager archiveManager) throws ArchiveException {
        switch (archive.type) {
            case ArchiveConstant.zip:
                archiveManager.zipExtract();
                break;
            case ArchiveConstant.tar:
                archiveManager.tarExtract();
                break;
        }
    }

    @Override
    public Class<?> dataClass() {
        return ArchiveInput.class;
    }

    @Override
    public TaskInput<Archive> dataFullExample() {
        ArchiveInput input = new ArchiveInput();
        input.action = ArchiveDescriptor.action;
        input.operation = "Example of Archive Plugin.";
        input.input.source = "source/path/xyz.zip";
        input.input.output = "source/path/xyz";
        input.input.type = "zip";
        input.input.archiveAction = ArchiveConstant.extract;
        return input;
    }
}
