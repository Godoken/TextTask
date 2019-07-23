package com.company.find;

import java.io.*;
import java.util.ArrayList;

public class ThreadFinderByData extends Thread {
    private String path;
    private ArrayList<String> res;
    private String data;

    void setArguments(String path, ArrayList<String> res, String data) {
        this.path = path;
        this.res = res;
        this.data = data;
    }

    ArrayList<String> getRes() {
        return res;
    }

    public void run() {
        File dir = new File(path);
        File[] list = dir.listFiles();
        ThreadFinderByData threadFinderByData = new ThreadFinderByData();

        if (list != null){
            for (File file : list) {
                if (file.isFile()) {
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                        String fileLine;
                        while ((fileLine = bufferedReader.readLine()) != null) {
                            if (fileLine.contains(data)) {
                                res.add(file.getCanonicalPath());
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        threadFinderByData.setArguments(file.getCanonicalPath(), res, data);
                        threadFinderByData.run();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (threadFinderByData.isAlive()) {
            try {
                threadFinderByData.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
