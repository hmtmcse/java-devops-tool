package com.hmtmcse.devops

import spock.lang.Specification

class BismillahTest extends Specification {

    def "Start the DevOps Tool"(){
        expect: "The Application Execution will Start"
        String[] command = ["bismillah", "-help"];
        Bismillah.main(command)
    }

    def "Show Descriptor Example"(){
        expect: "The Application Execution will Start"
        String[] command = ["show", "-help"];
        Bismillah.main(command)
    }

}
