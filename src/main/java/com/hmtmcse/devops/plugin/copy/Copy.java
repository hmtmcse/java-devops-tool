package com.hmtmcse.devops.plugin.copy;

public class Copy {

    public String source;
    public String target;
    public CopyOption options = new CopyOption();


    public Copy setSource(String source) {
        this.source = source;
        return this;
    }


    public Copy setTarget(String target) {
        this.target = target;
        return this;
    }
}
