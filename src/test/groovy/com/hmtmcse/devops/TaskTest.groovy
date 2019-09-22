package com.hmtmcse.devops

import com.hmtmcse.common.util.TMUtil
import com.hmtmcse.devops.task.action.Action
import com.hmtmcse.devops.task.action.Task
import com.hmtmcse.devops.task.action.command.Copy
import com.hmtmcse.devops.task.action.command.MakeDir
import com.hmtmcse.devops.task.action.command.Move
import com.hmtmcse.devops.task.action.command.Remove
import com.hmtmcse.devops.task.action.command.SoftLink
import com.hmtmcse.devops.task.processor.InputToTask
import spock.lang.Shared
import spock.lang.Specification

class TaskTest extends Specification {

    @Shared
    String testContentPath
    InputToTask inputToTask
    Task task

    def setup() {
        testContentPath = TMUtil.testContentPath("java-devops-tool")
        inputToTask = new InputToTask()
        task = inputToTask.loadFromYMLFile(testContentPath + "/all-action-test.yml")
    }

    def "Name and Actions Available" (){
        expect: 'Action will empty & name will "Bismillah Task"'
        task.name == 'Bismillah Task'
    }

    def "Check Copy Property Availability" (){

        when: 'Copy Action should be Available'
        Copy copy = null
        Action action = null
        task.actions.each { Action a ->
            if (a.copy){
                copy = a.copy
                action = a
            }
        }

        then: "Copy Object will not null"
        copy != null


        and: "Copy source available"
        copy.source == ''


        and: "Copy destination available"
        copy.destination == ''


        and: "Check Options"
        action.options.removeDest == false
        action.options.recursive == true
        action.options.copyLink == false
    }


    def "Check Move Property Availability" (){

        when: 'Move Action should be Available'
        Move move = null
        Action action = null
        task.actions.each { Action a ->
            if (a.move){
                move = a.move
                action = a
            }
        }

        then: "Move Object will not null"
        move != null


        and: "Move source available"
        move.source == ''


        and: "Move destination available"
        move.destination == ''


        and: "Check Options"
        action.options.removeDest == false
        action.options.copyLink == false
    }

    def "Check Remove Property Availability" (){

        when: 'Move Action should be Available'
        Remove remove = null
        Action action = null
        task.actions.each { Action a ->
            if (a.remove){
                remove = a.remove
                action = a
            }
        }

        then: "Move Object will not null"
        remove != null


        and: "Move path available"
        remove.path == ''


        and: "Check Options"
        action.options.recursive == true
        action.options.force == true
        action.options.removeLink == false
    }

    def "Check Make Directory Property Availability" (){

        when: 'Make Dir Action should be Available'
        MakeDir makeDir = null
        Action action = null
        task.actions.each { Action a ->
            if (a.makeDir){
                makeDir = a.makeDir
                action = a
            }
        }

        then: "MakeDir Object will not null"
        makeDir != null


        and: "MakeDir path available"
        makeDir.path == ''


        and: "Check Options"
        action.options.recursive == true
        action.options.removeDest == false
    }

    def "Check Soft Link Property Availability" (){

        when: 'Soft Link Action should be Available'
        SoftLink softLink = null
        Action action = null
        task.actions.each { Action a ->
            if (a.softLink){
                softLink = a.softLink
                action = a
            }
        }

        then: "SoftLink Object will not null"
        softLink != null


        and: "SoftLink source available"
        softLink.source == ''


        and: "SoftLink destination available"
        softLink.destination == ''


        and: "Check Options"
        action.options.removeDest == false
    }


}
