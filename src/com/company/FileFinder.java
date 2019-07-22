package com.company;

import java.io.File;
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

    public ArrayList<String> getListByData(String directoryName, ArrayList<String> res, String data) throws IOException {
        // Поиск по контенту
        return res;
    }
}
