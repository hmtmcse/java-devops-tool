package com.hmtmcse.devops.plugin.mkdir

class MakeDirOption<T> {
    public Boolean recursive = true
    public Boolean removeDest = false

    Boolean getRecursive() {
        return recursive
    }

    T setRecursive(Boolean recursive) {
        this.recursive = recursive
        return T
    }

    Boolean getRemoveDest() {
        return removeDest
    }

    T setRemoveDest(Boolean removeDest) {
        this.removeDest = removeDest
        return T
    }
}
