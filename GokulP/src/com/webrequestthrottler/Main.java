package com.webrequestthrottler;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int numberOfThreads = 5;

    public static void main(String args[]) {
        TaskGenerator generateTask = new TaskGenerator();
        generateTask.start();
        int index = 0;
        while (index++ < numberOfThreads) {
            ExecuteTask executeTask = new ExecuteTask(generateTask);
            executeTask.start();
        }
    }
}
