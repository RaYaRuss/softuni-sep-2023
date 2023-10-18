package com.plannerapp.service.impl;

import com.plannerapp.model.dto.TaskDto;
import com.plannerapp.model.dto.TaskHomeViewModel;
import com.plannerapp.model.dto.TasksAddBindingModel;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, PriorityRepository priorityRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(TasksAddBindingModel tasksAddBindingModel) {
        Priority priority = priorityRepository.findByName(tasksAddBindingModel.getPriority());

        if (priority != null) {
            Task task = new Task();
            task.setDescription(tasksAddBindingModel.getDescription());
            task.setDueDate(LocalDate.parse(tasksAddBindingModel.getDueDate()));
            task.setPriority(priority);

            taskRepository.save(task);
        }
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void assign(Long id, String username) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (username == null) {
                task.setAssignee(null);
            } else {
                User user = userRepository.findByUsername(username);
                task.setAssignee(user);
            }

            taskRepository.save(task);
        }
    }

    @Override
    public TaskHomeViewModel getHomeViewData(String username) {
        User user = userRepository.findByUsername(username);

        List<TaskDto> assignedTasks = taskRepository.findByAssignee(user)
                .stream()
                .map(TaskDto::createFromTask).toList();

        List<TaskDto> availableTasks = taskRepository.getAllAvailable()
                .stream()
                .map(TaskDto::createFromTask).toList();;

        return new TaskHomeViewModel(assignedTasks, availableTasks);
    }
}
