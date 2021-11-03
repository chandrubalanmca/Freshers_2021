package com.impiger.asyncthrottler.controller;

import com.impiger.asyncthrottler.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    private int numberOfThread = 5;

    @GetMapping("/start-task")
    public String getCompletedTask() {
        taskService.createTask();
        while (numberOfThread-- > 0)
            taskService.startTask();
        return "Web Request throttler Successfully Started";
    }
}
