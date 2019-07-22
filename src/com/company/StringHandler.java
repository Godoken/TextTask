package com.company;

import java.util.ArrayList;

class StringHandler {

    ArrayList<String> getArguments(String task) {
        ArrayList<String> arguments = new ArrayList<>();

        String taskArg = "";
        String directoryArg = "";
        String nameOrDataArg = "";

        String[] strings = task.split(" ");

        if (strings.length == 3){
            for (int i = 0; i < strings.length; i++) {
                switch (i) {
                    case 0:
                        if ((strings[0].equals("--name")) | (strings[0].equals("--data"))) {
                            taskArg = strings[0];
                        }
                        break;
                    case 1:
                        nameOrDataArg = strings[1];
                        break;
                    case 2:
                        directoryArg = strings[2];
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
