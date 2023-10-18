package com.plannerapp.service;

import com.plannerapp.model.dto.TaskHomeViewModel;
import com.plannerapp.model.dto.TasksAddBindingModel;

public interface TaskService {

    void add(TasksAddBindingModel tasksAddBindingModel);

    void remove(Long id);

    void assign(Long id,String username);

    TaskHomeViewModel getHomeViewData(String username);
}
