package com.hmtmcse.devops.task.action

import com.hmtmcse.devops.task.action.command.*


class Action {

    public String name
    public String actionName
    public String destination
    public String source
    public Options options


    public Archive archive
    public FindReplace findReplace
    public LinuxOperator linuxOperator
    public LinuxService linuxService
    public MySQL mySQL
    public OSPermission osPermission
    public SELinux seLinux
    public ShellCommand shellCommand


}
