package com.company;

import java.io.File;
import java.io.FilenameFilter;

public class NameFilter implements FilenameFilter {
    private String name;

    public NameFilter(String name) {
        this.name = name;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.equals(this.name);
    }
}
