package com.hmtmcse.devops.plugin.mkdir;

import com.hmtmcse.devops.data.ExitOnFailed;

public class MakeDirOption extends ExitOnFailed {

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