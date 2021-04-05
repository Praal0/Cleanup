package com.cleanup.todoc.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    // REPOSITORIES
    private final TaskDataRepository taskDataSource;
    private final Executor executor;

    // DATA

    public TaskViewModel(TaskDataRepository taskDataSource, Executor executor) {
        this.taskDataSource = taskDataSource;
        this.executor = executor;
    }

    // -------------
    // FOR TASK
    // -------------

    public void createTask(Task task) {
        executor.execute(() -> {
            taskDataSource.createItem(task);
        });
    }

    public void deleteTask(Task task) {
        executor.execute(() -> {
            taskDataSource.deleteItem(task);
        });
    }

    public void updateTask(Task task) {
        executor.execute(() -> {
            taskDataSource.updateItem(task);
        });
    }
}