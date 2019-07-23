package com.company.find;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ThreadFinderByName extends Thread {
    private String path;
    private ArrayList<String> res;
    private String name;

    void setArguments(String path, ArrayList<String> res, String name) {
        this.path = path;
        this.res = res;
        this.name = name;
    }

    ArrayList<String> getRes() {
        return res;
    }

    public void run() {
        File dir = new File(path);
        File[] list = dir.listFiles();
        ThreadFinderByName threadFinderByName = new ThreadFinderByName();

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
                        threadFinderByName.setArguments(file.getCanonicalPath(), res, name);
                        threadFinderByName.run();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (threadFinderByName.isAlive()) {
            try {
                threadFinderByName.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
