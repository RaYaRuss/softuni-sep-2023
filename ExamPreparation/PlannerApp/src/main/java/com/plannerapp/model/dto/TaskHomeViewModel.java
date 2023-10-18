package com.plannerapp.model.dto;


import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {

    private List<TaskDto> assignedTasks;

    private List<TaskDto> availableTasks;
    private int availableSize;

    public TaskHomeViewModel(List<TaskDto> assignedTasks, List<TaskDto> availableTasks) {
        this.assignedTasks = assignedTasks;
        this.availableTasks = availableTasks;
        this.availableSize = availableTasks.size();
    }

    public TaskHomeViewModel() {

        this(new ArrayList<>(), new ArrayList<>());
    }

    public int getAvailableSize() {
        return availableSize;
    }

    public List<TaskDto> getAssignedTasks() {
        return assignedTasks;
    }


    public List<TaskDto> getAvailableTasks() {
        return availableTasks;
    }


}
