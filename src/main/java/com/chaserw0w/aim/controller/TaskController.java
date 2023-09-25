package com.chaserw0w.aim.controller;

import com.chaserw0w.aim.domain.Task;
import com.chaserw0w.aim.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aim")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("/tasks")
    public String getTasks(Model model) {

        model.addAttribute("tasks", taskRepository.findAll());

        return "task/task-list";
    }

    @GetMapping("/task-create")
    public String createTaskForm(Task task) {
        return "task/task-create";
    }
}
