package com.hmtmcse.devops.plugin.remove;

import com.hmtmcse.devops.data.ExitOnFailed;

public class RemoveOption extends ExitOnFailed {
    public Boolean recursive = true;
    public Boolean removeIfExist = true;
}
