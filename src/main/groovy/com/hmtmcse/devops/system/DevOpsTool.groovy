package com.hmtmcse.devops.system

import com.fasterxml.jackson.databind.ObjectMapper
import com.hmtmcse.devops.data.TaskDescriptorExample
import com.hmtmcse.devops.plugin.archive.ArchiveDescriptor
import com.hmtmcse.devops.plugin.copy.CopyDescriptor
import com.hmtmcse.devops.plugin.findreplace.FindReplaceDescriptor
import com.hmtmcse.devops.plugin.mkdir.MakeDirDefinition
import com.hmtmcse.devops.plugin.move.MoveDescriptor
import com.hmtmcse.devops.plugin.remove.RemoveDefinition
import com.hmtmcse.devops.data.TaskDescriptor
import com.hmtmcse.devops.plugin.shell.ShellDescriptor
import com.hmtmcse.devops.plugin.softlink.SoftLinkDescriptor
import com.hmtmcse.devops.system.plugin.PluginRegistry
import com.hmtmcse.devops.system.processor.YmlProcessor
import com.hmtmcse.devops.system.skeleton.PluginDefinition

class DevOpsTool implements PluginRegistry {

    YmlProcessor ymlProcessor

    public DevOpsTool() {
        initBuiltInPlugin()
        initPluginJar()
        ymlProcessor = new YmlProcessor()
    }

    private initBuiltInPlugin() {
        addPlugin(MakeDirDefinition.action, new MakeDirDefinition())
        addPlugin(RemoveDefinition.action, new RemoveDefinition())
        addPlugin(CopyDescriptor.action, new CopyDescriptor())
        addPlugin(MoveDescriptor.action, new MoveDescriptor())
        addPlugin(ArchiveDescriptor.action, new ArchiveDescriptor())
        addPlugin(ShellDescriptor.action, new ShellDescriptor())
        addPlugin(SoftLinkDescriptor.action, new SoftLinkDescriptor())
        addPlugin(FindReplaceDescriptor.action, new FindReplaceDescriptor())
    }

    private initPluginJar() {

    }

    void showSample() {
        TaskDescriptorExample taskDescriptor = new TaskDescriptorExample()
        taskDescriptor.taskName = "Sample Task"
        taskDescriptor.variables.put("__NAME__", "This is My Name")
        taskDescriptor.variables.put("__SERVER__", "This is My Server")
        ymlProcessor = new YmlProcessor()
        getAllPlugins().each { String name, PluginDefinition pluginDefinition ->
            if (pluginDefinition.dataFullExample()) {
                taskDescriptor.actions.add(pluginDefinition.dataFullExample())
            }
        }
        println(ymlProcessor.objectToYmlString(taskDescriptor))
    }

    void executeTask(String location, Map<String, String> keywords = [:]) {
        TaskDescriptor taskDescriptor = ymlProcessor.ymlFileToObject(location, keywords)
        if (taskDescriptor.actions) {
            ObjectMapper objectMapper = new ObjectMapper()
            PluginDefinition pluginDefinition
            taskDescriptor.actions.each { Map map ->
                if (map && map.action && getAllPlugins().get(map.action)){
                    pluginDefinition = getAllPlugins().get(map.action)
                    pluginDefinition.executeTask(objectMapper.convertValue(map, pluginDefinition.dataClass()))
                }
            }
        }
    }

}
