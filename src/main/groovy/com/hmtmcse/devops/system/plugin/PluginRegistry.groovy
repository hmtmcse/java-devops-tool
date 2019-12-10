package com.hmtmcse.devops.system.plugin

import com.hmtmcse.devops.system.skeleton.PluginDefinition

trait PluginRegistry {

    private Map<String, PluginDefinition> plugins = [:]

    public PluginRegistry addPlugin(String identifier, PluginDefinition pluginDefinition){
        this.plugins.put(identifier, pluginDefinition)
        return this
    }

}
