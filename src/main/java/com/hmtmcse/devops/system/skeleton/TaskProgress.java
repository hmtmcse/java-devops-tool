package com.hmtmcse.devops.system.skeleton;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;

public interface TaskProgress {
    public void progress(TaskReport taskReport);
    public void message(String message);
}
