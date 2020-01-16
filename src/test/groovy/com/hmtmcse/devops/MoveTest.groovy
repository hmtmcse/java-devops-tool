package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import spock.lang.Shared

class MoveTest extends MakeDirTest {

    @Shared
    String movePath = TMUtil.testContentPath("java-devops-tool") + "/move"


    def "Move test"() {
        expect: "Move test"
        String[] command = ["bismillah", "-d", "${movePath}/move.yml"];
        Bismillah.main(command)
    }

}
