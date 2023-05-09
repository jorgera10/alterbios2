/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alterbios.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alterbios.backend.models.TaskModel;

/**
 *
 * @author jorge
 */
@Repository
public interface ITasksRespository extends JpaRepository<TaskModel, Long>{
    
}
