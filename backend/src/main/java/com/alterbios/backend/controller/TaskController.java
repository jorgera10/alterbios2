/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alterbios.backend.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alterbios.backend.models.TaskModel;
import com.alterbios.backend.services.TasksServices;

/**
 *
 * @author jorge
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TasksServices tasksServices;

    @GetMapping
    public ArrayList<TaskModel> getTask(){
        return this.tasksServices.getTask();
    }

    @PostMapping
    public TaskModel saveTask(@RequestBody TaskModel task){
        return this.tasksServices.saveTask(task);
    }

    @GetMapping(path = "/{id}")
    public Optional<TaskModel> getTaskById(@PathVariable("id") Long id){
        return this.tasksServices.getById(id);
    }

    @PutMapping(path = "/{id}")
    public TaskModel updateTaskById(@RequestBody TaskModel request, Long id){
        return this.tasksServices.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean eliminated = this.tasksServices.deleteTask(id);

        if(eliminated){
            return id + " deleted";
        }else{
            return "Error";
        }
    }
}
