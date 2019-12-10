package com.hmtmcse.devops.system

import com.hmtmcse.devops.plugin.mkdir.MakeDirDefinition
import com.hmtmcse.devops.system.plugin.PluginRegistry

class DevOpsTool implements PluginRegistry {


    public DevOpsTool() {
        initBuiltInPlugin()
        initPluginJar()
    }

    private initBuiltInPlugin() {
        addPlugin("makeDir", new MakeDirDefinition())
    }

    private initPluginJar() {

    }

}
