package com.hmtmcse.devops.plugin.move;

import com.hmtmcse.devops.data.ExitOnFailed;

public class MoveOption extends ExitOnFailed {
    public Boolean removeIfExist = true;
    public Boolean replaceExisting = true;
    public Boolean noFollowLinks = true;
}
