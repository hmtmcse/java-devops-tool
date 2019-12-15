package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import spock.lang.Shared
import spock.lang.Specification

class MakeDirTest extends Specification {

    @Shared
    String path = TMUtil.testContentPath("java-devops-tool") + "/mkdir"

    def "Create Directory Happy Test"() {
        expect: "Create Directory"
        String[] command = ["bismillah", "-d", "${path}/happy.yml"];
        Bismillah.main(command)
    }

    def "Create Directory with variable path test"() {
        expect: "Create Directory with variable path"
        String[] command = ["bismillah", "-d", "${path}/variableTask.yml", "-v", "${path}/variable.yml"];
        Bismillah.main(command)
    }

    def "Create Directory with variable list path test"() {
        expect: "Create Directory with variable list path"
        String[] command = ["bismillah", "-d", "${path}/variableTask.yml", "-v", "${path}/variableList.yml"];
        Bismillah.main(command)
    }

    def "No Option specified"() {
        expect: "No Option"
        String[] command = ["bismillah", "-d", "${path}/test-with-no-option.yml"];
        Bismillah.main(command)
    }

    def "No Path specified"() {
        expect: "No Path"
        String[] command = ["bismillah", "-d", "${path}/test-with-no-path.yml"];
        Bismillah.main(command)
    }

    def "No Recursive Path specified"() {
        expect: "No Path"
        String[] command = ["bismillah", "-d", "${path}/no-recursive.yml"];
        Bismillah.main(command)
    }

    def "Recursive Path specified"() {
        expect: "Recursive Path"
        String[] command = ["bismillah", "-d", "${path}/recursive-path.yml"];
        Bismillah.main(command)
    }
}
