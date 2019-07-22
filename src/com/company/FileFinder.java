package com.company;

import java.io.*;
import java.util.ArrayList;

class FileFinder {

    ArrayList<String> getListByName(String path, ArrayList<String> res, String name) throws IOException {

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

    ArrayList<String> getListByData(String path, ArrayList<String> res, String data) throws IOException {

        String fileLine;

        File dir = new File(path);
        File[] list = dir.listFiles();

        if (list != null){
            for (File file : list) {
                if (file.isFile()) {
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                        while ((fileLine = bufferedReader.readLine()) != null) {
                            if (fileLine.contains(data)) {
                                res.add(file.getCanonicalPath());
                                break;
                            }
                        }
                    }
                } else {
                    getListByData(file.getCanonicalPath(), res, data);
                }
            }
        }
        return res;
    }
}
