package com.impiger.asyncthrottler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;

@Service
public class TaskService {
    Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    private BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(1000);
    private Random random = new Random();


    @Async
    public void startTask() {

        int task = 0;
        String response = "";
        try {
            task = taskQueue.take();
            response = task + "";
            LOGGER.info("Task " + task + " Started in " + Thread.currentThread().getName());
            while (task > 0) {
                Thread.sleep(1000);
                task--;
            }
        } catch (InterruptedException e) {
        }
        if (task == 0) {
            response = "Task Succesfully Completed in " + response + " Seconds";
        } else {
            response = "Task " + response + " Not Completed ";
        }
        LOGGER.info(response + " & Total Task Remaining in Queue = " + taskQueue.size());
        startTask();
    }

    @Async
    public void createTask() {
        taskQueue.add(random.nextInt(50));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        createTask();
    }


}
