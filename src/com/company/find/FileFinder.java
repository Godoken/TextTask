package com.company.find;

import java.util.ArrayList;

public class FileFinder {
    public ArrayList<String> getListByName(String path, ArrayList<String> res, String name) {
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

    public ArrayList<String> getListByData(String path, ArrayList<String> res, String data) {
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
