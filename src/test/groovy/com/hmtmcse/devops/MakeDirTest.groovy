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


}
