package com.hmtmcse.devops.plugin.mkdir;

public class MakeDirOption {

    public Boolean recursive = true;
    public Boolean removeDest = false;

    public Boolean getRecursive() {
        return recursive;
    }

    public void setRecursive(Boolean recursive) {
        this.recursive = recursive;
    }

    Boolean getRemoveDest() {
        return removeDest;
    }

    public void setRemoveDest(Boolean removeDest) {
        this.removeDest = removeDest;
    }
}