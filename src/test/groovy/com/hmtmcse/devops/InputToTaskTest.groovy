package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import spock.lang.Shared
import spock.lang.Specification


class InputToTaskTest extends Specification {

    @Shared testContentPath

    def setup() {
        testContentPath = TMUtil.testContentPath("java-devops-tool")
    }

    def "Test TestContent Path Availability" (){
        expect:
         testContentPath != null
         println(testContentPath)
    }

}
