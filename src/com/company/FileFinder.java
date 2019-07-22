package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileFinder {

    public ArrayList<String> getListByName(String path, ArrayList<String> res, String name) throws IOException {

        String fileName;
        boolean extFile;

        File dir = new File(path);
        File[] list = dir.listFiles();

        if (list != null){
            for (File file : list) {

                if (file.isFile()) {

                    fileName = file.getName();
                    extFile = fileName.equals(name);

                    if (extFile) {
                        res.add(file.getCanonicalPath());
                    }

                } else {
                    getListByName(file.getCanonicalPath(), res, name);
                }
            }
        }
        return res;
    }

    public ArrayList<String> getListByData(String path, ArrayList<String> res, String data) throws IOException {

        String fileLine;

        File dir = new File(path);
        File[] list = dir.listFiles();

        if (list != null){
            for (File file : list) {

                if (file.isFile()) {

                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                        while ((fileLine = bufferedReader.readLine()) != null) {
                            if (fileLine.contains(data)) {
                                res.add(file.getCanonicalPath());
                                break;
                            }
                        }
                    }
                    /*fileName = file.getName();
                    extFile = fileName.equals(name);
                    if (extFile) {
                        res.add(file.getCanonicalPath());
                    }*/

                } else {
                    getListByName(file.getCanonicalPath(), res, data);
                }
            }
        }
        return res;
    }
}
