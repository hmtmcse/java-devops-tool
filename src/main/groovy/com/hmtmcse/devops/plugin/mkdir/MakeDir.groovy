package com.hmtmcse.devops.plugin.mkdir

import com.hmtmcse.devops.system.data.common.Location

class MakeDir extends Location<MakeDir> {

    MakeDirOption options = new MakeDirOption()

    MakeDirOption getOptions() {
        return options
    }

    MakeDir setOptions(MakeDirOption options) {
        this.options = options
        return this
    }

    MakeDir setDefaultOption() {
        this.options = new MakeDirOption()
        return this
    }
}
