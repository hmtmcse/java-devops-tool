package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import spock.lang.Shared

class ArchiveTest extends MakeDirTest {

    @Shared
    String archivePath = TMUtil.testContentPath("java-devops-tool") + "/archive"


    def "Extract Zip test"() {
        expect: "Extract Zip test"
        String[] command = ["bismillah", "-d", "${archivePath}/extract-zip.yml"];
        Bismillah.main(command)
    }

}
