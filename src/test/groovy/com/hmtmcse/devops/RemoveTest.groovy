package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import spock.lang.Shared

class RemoveTest extends MakeDirTest {

    @Shared
    String removePath = TMUtil.testContentPath("java-devops-tool") + "/remove"

    def "Remove Directory Happy Test"() {
        expect: "Remove Directory"
        String[] command = ["bismillah", "-d", "${removePath}/happy.yml"];
        Bismillah.main(command)
    }

    def "Remove Directory with variable path test"() {
        expect: "Remove Directory with variable path"
        String[] command = ["bismillah", "-d", "${removePath}/variableTask.yml", "-v", "${removePath}/variable.yml"];
        Bismillah.main(command)
    }

    def "Remove Directory with variable list path test"() {
        expect: "Remove Directory with variable list path"
        String[] command = ["bismillah", "-d", "${removePath}/variableTask.yml", "-v", "${removePath}/variableList.yml"];
        Bismillah.main(command)
    }

    def "Remove No Option specified"() {
        expect: "No Option"
        String[] command = ["bismillah", "-d", "${removePath}/test-with-no-option.yml"];
        Bismillah.main(command)
    }

    def "Remove No Path specified"() {
        expect: "No Path"
        String[] command = ["bismillah", "-d", "${removePath}/test-with-no-path.yml"];
        Bismillah.main(command)
    }


    def "Remove Recursive Path specified"() {
        expect: "Recursive Path"
        String[] command = ["bismillah", "-d", "${removePath}/recursive-path.yml"];
        Bismillah.main(command)
    }
}
