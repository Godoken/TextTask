package com.company;

import java.util.ArrayList;

public class StringHandler {

    public ArrayList<String> getArguments(String task) {
        ArrayList<String> arguments = new ArrayList<>();

        String taskArg = "";
        String directoryArg = "";
        String nameOrDataArg = "";

        String[] strings = task.split(" ");

        if (strings.length == 6){
            for (int i = 0; i < strings.length; i++) {
                switch (i) {
                    case 3:
                        if ((strings[3].equals("--name")) | (strings[3].equals("--data"))) {
                            taskArg = strings[3];
                        }
                        break;
                    case 4:
                        nameOrDataArg = strings[4];
                        break;
                    case 5:
                        directoryArg = strings[5];
                        break;
                }
            }
        }
        arguments.add(taskArg);
        arguments.add(directoryArg);
        arguments.add(nameOrDataArg);
        return arguments;
    }
}
