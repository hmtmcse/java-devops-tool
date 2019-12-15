package com.hmtmcse.devops.system

import com.fasterxml.jackson.databind.ObjectMapper
import com.hmtmcse.console.table.common.TableConstant
import com.hmtmcse.console.table.data.Table
import com.hmtmcse.console.table.data.TableRowData
import com.hmtmcse.devops.data.Status
import com.hmtmcse.devops.data.TaskDescriptorExample
import com.hmtmcse.devops.data.TaskProgressImp
import com.hmtmcse.devops.data.TaskReport
import com.hmtmcse.devops.plugin.archive.ArchiveDescriptor
import com.hmtmcse.devops.plugin.copy.CopyDescriptor
import com.hmtmcse.devops.plugin.findreplace.FindReplaceDescriptor
import com.hmtmcse.devops.plugin.mkdir.MakeDirDefinition
import com.hmtmcse.devops.data.TaskDescriptor
import com.hmtmcse.devops.plugin.move.MoveDescriptor
import com.hmtmcse.devops.plugin.remove.RemoveDefinition
import com.hmtmcse.devops.plugin.shell.ShellDescriptor
import com.hmtmcse.devops.plugin.softlink.SoftLinkDescriptor
import com.hmtmcse.devops.system.common.DevOpsException
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
        List<TaskReport> reports = []
        TaskDescriptor taskDescriptor = ymlProcessor.ymlFileToObject(location, keywords)
        if (taskDescriptor.actions) {
            ObjectMapper objectMapper = new ObjectMapper()
            PluginDefinition pluginDefinition
            TaskReport taskReport
            try{
                taskDescriptor.actions.each { Map map ->
                    if (map && map.action && getAllPlugins().get(map.action)){
                        pluginDefinition = getAllPlugins().get(map.action)
                        taskReport = pluginDefinition.executeTask(objectMapper.convertValue(map, pluginDefinition.dataClass()), logPrinter())
                        reports.add(taskReport)
                    }
                }
            }catch(DevOpsException exception){
                println(exception.getMessage())
                if (exception.taskReport){
                    reports.add(exception.taskReport)
                }
            }
        }
        showReport(reports)
    }

    private void tableRowData(Table table, String index, TaskReport tr){
        TableRowData rowData = table.setRowData(index);
        rowData.add(tr.action);
        rowData.add(tr.operation);
        if (tr.status == Status.SUCCESS){
            rowData.add(tr.status, TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        }else if (tr.status == Status.PARTIALLY_SUCCESS){
            rowData.add(tr.status, TableConstant.LEFT_ALIGN, TableConstant.YELLOW);
        }else{
            rowData.add(tr.status, TableConstant.LEFT_ALIGN, TableConstant.RED);
        }

        if (tr.error){
            rowData.add(tr.error, TableConstant.LEFT_ALIGN, TableConstant.RED);
        }else{
            rowData.add("");
        }
        table.addRow(rowData);
    }

    void showReport(List<TaskReport> reports = []) {
        Table table = new Table();
        table.addHeader("#", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Action", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Operation", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Status", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Error", TableConstant.LEFT_ALIGN, TableConstant.RED);
        Integer index = 1
        reports.each { TaskReport tr ->
            tableRowData(table, index + "", tr)
            if (tr.nestedTaskReport){
                tr.nestedTaskReport.each {TaskReport ntr ->
                    tableRowData(table,  "", ntr)
                }
            }
            index++
        }
        table.toTablePrint();
    }

    TaskProgressImp logPrinter() {
        return new TaskProgressImp()
    }

}
