package com.company;

import com.company.find.FileFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TaskPerformer {
    void performTask(ArrayList<String> arguments) {
        switch (arguments.get(0)) {
            case "--name":
                printFilesByName(arguments.get(1), arguments.get(2));
                break;
            case "--data":
                printFilesByData(arguments.get(1), arguments.get(2));
                break;
            default:
                printHelpMessage();
                break;
        }
    }

    private void printFilesByName(String directoryName, String fileName) {
        List<String> listFile = findFilesByName(directoryName, fileName);
        if (listFile.size() != 0){
            synchronized (listFile) {
                for (String s : listFile) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Не найдено");
        }
    }

    private List<String> findFilesByName(String directoryName, String fileName) {
        FileFinder fileFinder = new FileFinder();
        List<String> listArgument = Collections.synchronizedList(new ArrayList<>());
        return fileFinder.getListByName(directoryName, listArgument, fileName);
    }

    private void printFilesByData(String directoryName, String data) {
        List<String> listFile = findFilesByData(directoryName, data);
        if (listFile.size() != 0){
            synchronized (listFile) {
                for (String s : listFile) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Не найдено");
        }
    }

    private List<String> findFilesByData(String directoryName, String data) {
        FileFinder fileFinder  = new FileFinder();
        List<String> listArgument = Collections.synchronizedList(new ArrayList<>());
        return fileFinder.getListByData(directoryName, listArgument, data);
    }

    void printHelpMessage(){
        System.out.println("Чтобы найти файлы в директории по имени файла:"
                + "\n" +
                "--name {example_file_name} {example_directory_name}" + "\n");

        System.out.println("Чтобы найти файлы в директории по содержимому файла:"
                + "\n" +
                "--data {example_file_data} {example_directory_name}" + "\n");
    }
}
