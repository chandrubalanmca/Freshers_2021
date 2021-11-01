package com.webrequestthrottler;

public class ExecuteTask extends Thread {
    private final int time = 15;
    private TaskGenerator taskGenerator;

    public ExecuteTask(TaskGenerator taskGenerator) {
        this.taskGenerator = taskGenerator;
    }

    public void run() {
        int timer = 0, task = 0, temp;
        try {
            task = taskGenerator.getQueue().take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + task + " Started in " + currentThread().getName());
        temp = task;
        while (timer <= time) {
            if (temp == 0) break;
            try {
                Thread.sleep(1000);
                temp--;
                timer++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (temp != 0)
            System.out.println("Task " + task + " Not Completed");
        else
            System.out.println("Task " + task + " Successfully Completed");
        System.out.println("Total Task Remaining in Queue" + taskGenerator.getQueue());
        run();
    }
}
