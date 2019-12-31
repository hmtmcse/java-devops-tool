package com.hmtmcse.devops.plugin.findreplace;

import java.util.LinkedHashMap;

public class FindReplace {

    public String sourceFile;
    public String filePlaceTo;
    public LinkedHashMap<String, Object> findReplaceData;
    public FindReplaceOption options = new FindReplaceOption();

}
