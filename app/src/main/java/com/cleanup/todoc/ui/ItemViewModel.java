package com.cleanup.todoc.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class ItemViewModel extends ViewModel {

    // REPOSITORIES
    private final ProjectDataRepository projectDataSource;
    private final TaskDataRepository taskDataSource;
    private final Executor executor;

    // DATA

    public ItemViewModel(ProjectDataRepository projectDataSource, TaskDataRepository taskDataSource, Executor executor) {
        this.projectDataSource = projectDataSource;
        this.taskDataSource = taskDataSource;
        this.executor = executor;
    }

    // -------------
    // FOR PROJECT
    // -------------



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