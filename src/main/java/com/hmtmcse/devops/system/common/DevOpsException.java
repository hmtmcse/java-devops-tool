package com.hmtmcse.devops.system.common;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class DevOpsException extends Exception {

    public DevOpsException(){
        super("DevOps Exception Occurred!");
    }

    public DevOpsException(String message){
        super(message);
    }
}
