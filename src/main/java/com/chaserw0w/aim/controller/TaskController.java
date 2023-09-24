package com.chaserw0w.aim.controller;

import com.chaserw0w.aim.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @RequestMapping("/tasks")
    public String getTasks(Model model) {

        model.addAttribute("tasks", taskRepository.findAll());

        return "task/list";
    }
}
