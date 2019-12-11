package com.hmtmcse.devops.plugin.mkdir;

import com.hmtmcse.devops.data.common.Location;

public class MakeDir extends Location {

    public MakeDirOption options = new MakeDirOption();

    public MakeDirOption getOptions() {
        return options;
    }

    public MakeDir setOptions(MakeDirOption options) {
        this.options = options;
        return this;
    }

    public MakeDir setAllDefaultOption() {
        this.options = new MakeDirOption();
        return this;
    }
}