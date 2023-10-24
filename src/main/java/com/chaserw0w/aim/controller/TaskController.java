package com.chaserw0w.aim.controller;

import com.chaserw0w.aim.domain.Task;
import com.chaserw0w.aim.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aim")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);

        return "task/task-list";
    }

    @GetMapping("/task-create")
    public String createTaskForm(Task task) {
        return "task/task-create";
    }

    @PostMapping("/task-create")
    public String createTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/aim/tasks";
    }

    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "task/task-update";
    }

    @PostMapping("/task-update")
    public String updateTask(Task task) {
        taskService.saveTask(task);
        return "redirect:/aim/tasks";
    }

    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return "redirect:/aim/tasks";
    }
}
