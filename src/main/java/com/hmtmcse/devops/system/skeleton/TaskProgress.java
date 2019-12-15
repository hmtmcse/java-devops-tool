package com.hmtmcse.devops.system.skeleton;

import com.hmtmcse.devops.system.common.DevOpsException;

public interface TaskProgress {
    public void error(String message);
    public void errorThrowException(String message) throws DevOpsException;
    public void success(String message);
    public void warning(String message);
    public void message(String message);
    public void messageThrowException(String message) throws DevOpsException;
}
