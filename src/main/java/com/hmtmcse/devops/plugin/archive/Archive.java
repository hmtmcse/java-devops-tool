package com.hmtmcse.devops.plugin.archive;

public class Archive {
    public String source;
    public String output;
    public String type = ArchiveConstant.zip;
    public String archiveAction = ArchiveConstant.extract;
    public ArchiveOption options = new ArchiveOption();
}
