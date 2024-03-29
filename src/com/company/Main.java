package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringHandler stringHandler = new StringHandler();
    private static TaskPerformer taskPerformer = new TaskPerformer();

    private static String inputString = "";

    public static void main(String[] args) {
        readTask();

        if (!inputString.equals("")) {
            taskPerformer.performTask(stringHandler.getArguments(inputString));
        } else {
            taskPerformer.printHelpMessage();
        }
    }

    private static void readTask() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
