package com.company.find;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ThreadFinderByData extends Thread {
    private String path;
    private List<String> res;
    private String data;

    void setArguments(String path, List<String> res, String data) {
        this.path = path;
        this.res = res;
        this.data = data;
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
                    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
                        int i;
                        String fileLine = "";
                        while ((i = bufferedInputStream.read()) != -1) {

                            if (fileLine.length() == data.length()) {
                                if(fileLine.equals(data)) {
                                    res.add(file.getCanonicalPath());
                                    break;
                                } else {
                                    fileLine = fileLine.substring(1);
                                }
                            } else {
                                fileLine = fileLine.concat(String.valueOf((char)i));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        ThreadFinderByData threadFinderByData = new ThreadFinderByData();
                        threadFinderByData.setArguments(file.getCanonicalPath(), res, data);
                        threadFinderByData.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
