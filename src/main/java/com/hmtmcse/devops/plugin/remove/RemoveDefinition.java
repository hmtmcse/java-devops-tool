package com.hmtmcse.devops.plugin.remove;


import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.PluginDefinition;
import com.hmtmcse.devops.system.skeleton.TaskInput;
import com.hmtmcse.devops.system.skeleton.TaskProgress;
import com.hmtmcse.fileutil.common.FileUtilException;
import com.hmtmcse.fileutil.fd.FileDirectory;

public class RemoveDefinition implements PluginDefinition<Remove> {

    public static final String action = "remove";


    @Override
    public TaskReport executeTask(TaskInput<Remove> taskInput, TaskProgress taskProgress) throws DevOpsException {
        TaskReport taskReport = new TaskReport();
        taskReport.taskProgress = taskProgress;
        try {
            FileDirectory fileDirectory = new FileDirectory();
            String path = taskInput.getInput().path;
            if (path == null || path.equals("")) {
                taskReport.failed(taskInput.getAction(), taskInput.getOperation(), "Empty Path");
                return taskReport;
            }

            if (taskInput.getInput().options.removeIfExist){
                if (!fileDirectory.isExist(path)){
                    taskReport.success(taskInput.getAction(), "File / Directory Not Exist");
                    return taskReport;
                }
            }

            if (taskInput.getInput().options.recursive) {
                fileDirectory.removeAll(path);
            } else {
                fileDirectory.remove(path);
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
        return RemoveInput.class;
    }

    @Override
    public TaskInput<Remove> dataFullExample() {
        RemoveInput removeInput = new RemoveInput();
        removeInput.operation = "Example of Remove";
        removeInput.input.path = "/this/is/the/path";
        return removeInput;
    }

}
