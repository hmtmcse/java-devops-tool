package com.hmtmcse.devops.task.executor

import com.hmtmcse.devops.task.action.Action
import com.hmtmcse.devops.task.model.TaskExecutor

class ExecutorBuilder {

    public static TaskExecutor taskExecutor(Action action) {

        if (action.copy) {
            return new CopyExecutor()
        }

        if (action.makeDir) {
            return new MakeDirExecutor()
        }

        if (action.move) {
            return new MoveExecutor()
        }

        if (action.remove) {
            return new RemoveExecutor()
        }

        if (action.softLink) {
            return new SoftLinkExecutor()
        }

        if (action.archive) {
            return new ArchiveExecutor()
        }

        if (action.findReplace) {
            return new FindReplaceExecutor()
        }

        if (action.linuxOperator) {
            return new LinuxOperatorExecutor()
        }

        if (action.linuxService) {
            return new LinuxServiceExecutor()
        }

        if (action.mySQL) {
            return new MySQLExecutor()
        }

        if (action.osPermission) {
            return new OSPermissionExecutor()
        }

        if (action.seLinux) {
            return new SELinuxExecutor()
        }

        if (action.shellCommand) {
            return new ShellCommandExecutor()
        }

        if (action.ansible) {
            return new AnsibleExecutor()
        }

        return null
    }

}
