package com.company;

import com.company.find.FileFinder;

import java.util.ArrayList;

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
        ArrayList<String> listFile = findFilesByName(directoryName, fileName);
        if (listFile.size() != 0){
            for (String s : listFile) {
                System.out.println(s);
            }
        } else {
            System.out.println("Не найдено");
        }
    }

    private ArrayList<String> findFilesByName(String directoryName, String fileName) {
        FileFinder fileFinder = new FileFinder();
        ArrayList<String> listArgument = new ArrayList<>();
        return fileFinder.getListByName(directoryName, listArgument, fileName);
    }

    private void printFilesByData(String directoryName, String data) {
        ArrayList<String> listFile = findFilesByData(directoryName, data);
        if (listFile.size() != 0){
            for (String s : listFile) {
                System.out.println(s);
            }
        } else {
            System.out.println("Не найдено");
        }
    }

    private ArrayList<String> findFilesByData(String directoryName, String data) {
        FileFinder fileFinder  = new FileFinder();
        ArrayList<String> listArgument = new ArrayList<>();
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
