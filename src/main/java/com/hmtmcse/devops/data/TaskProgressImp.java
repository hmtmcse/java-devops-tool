package com.hmtmcse.devops.data;

import com.hmtmcse.devops.system.common.DevOpsException;
import com.hmtmcse.devops.system.skeleton.TaskProgress;

public class TaskProgressImp implements TaskProgress {

    @Override
    public void error(String message) {
        System.err.println(message);
    }

    @Override
    public void errorThrowException(String message) throws DevOpsException {

        throw new DevOpsException(message);
    }

    @Override
    public void success(String message) {
        System.out.println(message);
    }

    @Override
    public void warning(String message) {
        System.out.println(message);
    }

    @Override
    public void message(String message) {
        System.out.println(message);
    }

    @Override
    public void messageThrowException(String message) throws DevOpsException {
        throw new DevOpsException(message);
    }
}
