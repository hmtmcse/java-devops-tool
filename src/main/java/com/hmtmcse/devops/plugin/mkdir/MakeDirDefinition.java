package com.hmtmcse.devops.plugin.mkdir;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.fileutil.common.FileUtilException;
import com.hmtmcse.fileutil.fd.FileDirectory;

public class MakeDirDefinition implements PluginDefinition<MakeDir> {

    public static final String action = "makeDir";

    @Override
    public TaskReport executeTask(TaskInput<MakeDir> taskInput, TaskProgress taskProgress) throws DevOpsException {

        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;

        try {
            FileDirectory fileDirectory = new FileDirectory();
            String path = taskInput.getInput().path;
            if (path == null || path.equals("")) {
                taskReport.failed(taskInput.getAction(), taskInput.getOperation(), "Empty Path");
                return taskReport;
            }

            if (taskInput.getInput().options.removeDest && fileDirectory.isExist(path)) {
                fileDirectory.removeAll(path);
                taskReport.nested().success("delete", "Delete Destination");
            }

            if (taskInput.getInput().options.createIfNotExist) {
                if (!fileDirectory.isExist(path)) {
                    taskReport.success(taskInput.getAction(), "Directory Already Exist");
                    return taskReport;
                }
            }

            if (taskInput.getInput().options.recursive) {
                fileDirectory.createDirectories(path);
            } else {
                fileDirectory.createDirectory(path);
            }

            taskReport.success(taskInput.getAction(), taskInput.getOperation());
        } catch (FileUtilException e) {
            taskReport.failed(taskInput.getAction(), taskInput.getOperation(), e.getMessage());
            if (taskInput.getInput().options.isExitOnFailed) {
                throw new DevOpsException(e.getMessage()).setTaskReport(taskReport);
            }
        }
        return taskReport;
    }

    @Override
    public Class<?> dataClass() {
        return MakeDirInput.class;
    }

    @Override
    public TaskInput<MakeDir> dataFullExample() {
        MakeDirInput input = new MakeDirInput();
        input.action = action;
        input.operation = "Example Make Directory Operation.";
        MakeDir makeDir = new MakeDir();
        makeDir.setPath("/this/is/path");
        makeDir.setAllDefaultOption();
        input.input = makeDir;
        return input;
    }
}