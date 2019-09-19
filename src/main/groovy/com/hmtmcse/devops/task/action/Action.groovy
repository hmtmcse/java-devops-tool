package com.hmtmcse.devops.task.action

import com.hmtmcse.devops.task.action.command.*


class Action {

    public String linuxSudo = false

    public String name
    public Options options

    public Copy copy
    public MakeDir makeDir
    public Move move
    public Remove remove
    public SoftLink softLink

    public Archive archive
    public FindReplace findReplace
    public LinuxOperator linuxOperator
    public LinuxService linuxService
    public MySQL mySQL
    public OSPermission osPermission
    public SELinux seLinux
    public ShellCommand shellCommand
    public Ansible ansible


}
