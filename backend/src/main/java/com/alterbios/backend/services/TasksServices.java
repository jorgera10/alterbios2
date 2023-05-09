/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alterbios.backend.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alterbios.backend.models.TaskModel;
import com.alterbios.backend.repositories.ITasksRespository;

/**
 *
 * @author jorge
 */
@Service
public class TasksServices {

    @Autowired
    ITasksRespository tasksRespository;
    public ArrayList<TaskModel> getTask(){
        return (ArrayList<TaskModel>) tasksRespository.findAll();
    }

    public TaskModel saveTask(TaskModel task){
        return tasksRespository.save(task);
    }

    public Optional<TaskModel> getById(Long id){
        return tasksRespository.findById(id);
    }

    public TaskModel updateById(TaskModel request, Long id){
        TaskModel task = tasksRespository.findById(id).get();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setImportance(request.getImportance());
        task.setFinishDate(request.getFinishDate());
        task.setFixed(request.getFixed());
        task.setTaskType(request.getTaskType());

        return task;
    
    }

    public Boolean deleteTask (Long id){
        try {
            tasksRespository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
