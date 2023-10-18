package com.plannerapp.model.dto;


import com.plannerapp.model.entity.Task;
import com.plannerapp.model.enums.PriorityName;


public class TaskDto {

    private Long id;


    private String description;

    private String dueDate;


    private PriorityName priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }

    public static TaskDto createFromTask(Task task) {
        TaskDto taskDto = new TaskDto();

        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriority(task.getPriority().getName());
        taskDto.setDueDate(taskDto.getDueDate());

        return taskDto;
    }

}
