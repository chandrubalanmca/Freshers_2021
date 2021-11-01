package com.webrequestthrottler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskGenerator extends Thread {
    private Random random = new Random();
    private BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<Integer>(1000);

    public void run() {
        addNewTask();
        try {
            this.sleep(3100);
        } catch (InterruptedException e) {
        }
        run();
    }

    private void addNewTask() {
        taskQueue.add(random.nextInt(50));
    }

    public BlockingQueue<Integer> getQueue() {
        return taskQueue;
    }
}
