package com.company.find;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ThreadFinderByName extends Thread {
    private String path;
    private List<String> res;
    private String name;

    void setArguments(String path, List<String> res, String name) {
        this.path = path;
        this.res = res;
        this.name = name;
    }

    List<String> getRes() {
        return res;
    }

    public void run() {
        File dir = new File(path);
        File[] list = dir.listFiles();

        if (list != null){
            for (File file : list) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    boolean extFile = fileName.equals(name);
                    if (extFile) {
                        try {
                            res.add(file.getCanonicalPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        ThreadFinderByName threadFinderByName = new ThreadFinderByName();
                        threadFinderByName.setArguments(file.getCanonicalPath(), res, name);
                        threadFinderByName.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
