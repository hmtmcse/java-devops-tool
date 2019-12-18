package com.hmtmcse.devops.system

import com.fasterxml.jackson.databind.ObjectMapper
import com.hmtmcse.console.table.common.TableConstant
import com.hmtmcse.console.table.data.Table
import com.hmtmcse.console.table.data.TableRowData
import com.hmtmcse.devops.data.Status
import com.hmtmcse.devops.data.TaskDescriptorExample
import com.hmtmcse.devops.data.TaskProgressImp
import com.hmtmcse.devops.data.TaskReport
import com.hmtmcse.devops.data.TaskVariable
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

    private YmlProcessor ymlProcessor
    private Table table;
    private Integer index = 1;
    private List<TaskReport> fullReport = []

    public DevOpsTool() {
        initBuiltInPlugin()
        initPluginJar()
        ymlProcessor = new YmlProcessor()
        reportInit()
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

        ymlProcessor = new YmlProcessor()
        getAllPlugins().each { String name, PluginDefinition pluginDefinition ->
            if (pluginDefinition.dataFullExample()) {
                taskDescriptor.actions.add(pluginDefinition.dataFullExample())
            }
        }

        TaskVariable taskVariable = new TaskVariable()
        LinkedHashMap<String, String> variable = [:]
        variable.put("__NAME__", "This is My Name")
        variable.put("__SERVER__", "This is My Server")
        taskVariable.variables = variable;
        List list = []
        list.add(variable)
        taskVariable.variableList = list;
        println("========= Variable Example =========")
        println(ymlProcessor.objectToYmlString(taskVariable))
        println("")
        println(ymlProcessor.objectToYmlString(taskDescriptor))
    }

    void executeTask(String location, String variableLocation) {
        if (!variableLocation) {
            executeTask(location)
            return
        }
        try {
            TaskVariable taskVariable = ymlProcessor.ymlFileToVariable(variableLocation)
            if (taskVariable && taskVariable.variables) {
                executeTask(location, taskVariable.variables)
            } else if (taskVariable && taskVariable.variableList) {
                taskVariable.variableList.each {
                    executeTask(location, it)
                }
            } else {
                executeTask(location)
            }
        } catch (Exception e) {
            executeTask(location)
        }
    }

    void executeTask(String location, Map<String, String> keywords = [:]) {
        List<TaskReport> reports = []
        TaskDescriptor taskDescriptor = ymlProcessor.ymlFileToObject(location, keywords)
        if (taskDescriptor.actions) {
            ObjectMapper objectMapper = new ObjectMapper()
            PluginDefinition pluginDefinition
            TaskReport taskReport
            try {
                taskDescriptor.actions.each { Map map ->
                    if (map && map.action && getAllPlugins().get(map.action)) {
                        pluginDefinition = getAllPlugins().get(map.action)
                        try {
                            taskReport = pluginDefinition.executeTask(objectMapper.convertValue(map, pluginDefinition.dataClass()), logPrinter())
                        } catch (DevOpsException exception) {
                            if (exception.taskReport) {
                                reports.add(exception.taskReport)
                            }
                            return
                        }
                        reports.add(taskReport)
                    }
                }
            } catch (DevOpsException exception) {
                println(exception.getMessage())
                if (exception.taskReport) {
                    reports.add(exception.taskReport)
                }
            }
        }
        fullReport.addAll(reports)
    }

    private void tableRowData(Table table, String index, TaskReport tr) {
        TableRowData rowData = table.setRowData(index);
        rowData.add(tr.action);
        rowData.add(tr.operation);
        if (tr.status == Status.SUCCESS) {
            rowData.add(tr.status, TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        } else if (tr.status == Status.PARTIALLY_SUCCESS) {
            rowData.add(tr.status, TableConstant.LEFT_ALIGN, TableConstant.YELLOW);
        } else {
            rowData.add(tr.status, TableConstant.LEFT_ALIGN, TableConstant.RED);
        }

        if (tr.error) {
            rowData.add(tr.error, TableConstant.LEFT_ALIGN, TableConstant.RED);
        } else {
            rowData.add("");
        }
        table.addRow(rowData);
    }

    void reportInit() {
        table = new Table();
        table.addHeader("#", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Action", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Operation", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Status", TableConstant.LEFT_ALIGN, TableConstant.BLUE);
        table.addHeader("Error", TableConstant.LEFT_ALIGN, TableConstant.RED);
    }

    void showReport() {
        consoleTableReport(this.fullReport)
    }

    List<TaskReport> getReport() {
        return this.fullReport
    }

    void consoleTableReport(List<TaskReport> reports = []) {
        reports.each { TaskReport tr ->
            tableRowData(table, index + "", tr)
            if (tr.nestedTaskReport) {
                tr.nestedTaskReport.each { TaskReport ntr ->
                    tableRowData(table, "", ntr)
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
