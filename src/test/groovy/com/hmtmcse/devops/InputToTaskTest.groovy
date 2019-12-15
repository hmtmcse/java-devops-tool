package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import com.hmtmcse.devops.system.common.DevOpsException
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.devops.task.processor.InputToTask
import spock.lang.Shared
import spock.lang.Specification

class InputToTaskTest extends Specification {

    @Shared
    String testContentPath
    InputToTask inputToTask
    String ymlFilePath
    String ymlVariableFilePath
    String ymlInvalidFilePath

    String jsonFilePath
    String jsonVariableFilePath
    String jsonInvalidFilePath

    def setup() {
        testContentPath = TMUtil.testContentPath("java-devops-tool")
        inputToTask = new InputToTask()

        ymlFilePath = testContentPath + "/yml-file.yml"
        ymlInvalidFilePath = testContentPath + "/yml-invalid-file.yml"
        ymlVariableFilePath = testContentPath + "/yml-variable-file.yml"

        jsonFilePath = testContentPath + "/json-file.json"
        jsonInvalidFilePath = testContentPath + "/json-invalid-file.json"
        jsonVariableFilePath = testContentPath + "/json-variable-file.json"
    }

    def "Test TestContent Path Availability"() {

        expect: "Test Content Path will not null."
        testContentPath != null
        println(testContentPath)
    }

    def "Load YML task from file not exist"() {

        when: "Try to load file"
        Task task = inputToTask.loadFromYMLFile(ymlFilePath)

        then: "Get File not Exist Exception."
        task.name == "Bismillah Task"
    }

    def "Load YML task from invalid file"() {

        when: "Try to load file"
        inputToTask.loadFromYMLFile(ymlInvalidFilePath)

        then: "Get File parse exception."
        thrown DevOpsException

    }


    def "Load YML task from file & variable from file"() {

        when: "Try to load file"
        Task task = inputToTask.loadFromYMLFile(ymlFilePath, ymlVariableFilePath)

        then: "Get File not Exist Exception."
        task.name == "Bismillah Task"
        task.variables['__ADDRESS__'] == 'new-address'

    }

}
