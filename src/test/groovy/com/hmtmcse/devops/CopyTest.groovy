package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import spock.lang.Shared

class CopyTest extends MakeDirTest {

    @Shared
    String shellPath = TMUtil.testContentPath("java-devops-tool") + "/shell"


    def "Shell test"() {
        expect: "Shell test"
        String[] command = ["bismillah", "-d", "${shellPath}/shell.yml"];
        Bismillah.main(command)
    }

}
