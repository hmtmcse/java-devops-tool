package com.hmtmcse.devops.system.skeleton;

import com.hmtmcse.devops.data.TaskReport;
import com.hmtmcse.devops.system.common.DevOpsException;

import java.util.LinkedHashMap;

public interface TaskProgress {
    public void progress(TaskReport taskReport);
    public void message(String message);
    public void message(LinkedHashMap<String, Object> data, String message, String status);
}
