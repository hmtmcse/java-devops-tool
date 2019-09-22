package com.hmtmcse.devops

import com.hmtmcse.common.CommonConst
import com.hmtmcse.devops.common.Config
import com.hmtmcse.devops.common.ConfigLoader
import spock.lang.Specification

class ConfigLoaderTest extends Specification {

    String invalidConfigFile = CommonConst.TEST_CONTENT_DIRECTORY + "/" + "yml-file.yml"
    String emptyConfigFile = CommonConst.TEST_CONTENT_DIRECTORY + "/" + "empty-file.yml"
    String validConfigFile = CommonConst.TEST_CONTENT_DIRECTORY + "/" + "config.yml"

    def "Invalid Config File Test"(){

        when: "Load Config File"
        ConfigLoader.CONFIG_FILE = invalidConfigFile
        Config config = ConfigLoader.getConfig()

        then: "Debug Test will false"
        config.debugTest == false
    }

    def "Empty Config File Test"(){
        when: "Load Config File"
        ConfigLoader.CONFIG_FILE = emptyConfigFile
        Config config = ConfigLoader.getConfig()

        then: "Debug Test will false"
        config.debugTest == false
    }

    def "Valid Config Test"(){
        when: "Load Config"
        ConfigLoader.CONFIG_FILE = validConfigFile
        Config config = ConfigLoader.getConfig()

        then: "Debug Test will true"
        config.debugTest == true
    }

}
