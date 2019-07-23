package com.company.find;

import java.util.List;

public class FileFinder {
    public List<String> getListByName(String path, List<String> res, String name) {
        ThreadFinderByName threadFinderByName = new ThreadFinderByName();
        threadFinderByName.setArguments(path, res, name);
        threadFinderByName.start();
        try {
            threadFinderByName.join();
            res = threadFinderByName.getRes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<String> getListByData(String path, List<String> res, String data) {
        ThreadFinderByData threadFinderByData = new ThreadFinderByData();
        threadFinderByData.setArguments(path, res, data);
        threadFinderByData.start();
        try {
            threadFinderByData.join();
            res = threadFinderByData.getRes();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
}
