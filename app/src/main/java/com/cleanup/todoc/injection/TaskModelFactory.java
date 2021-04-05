package com.cleanup.todoc.injection;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;
import com.cleanup.todoc.ViewModel.TaskViewModel;

import java.util.concurrent.Executor;

public class TaskModelFactory implements ViewModelProvider.Factory {


    private final TaskDataRepository taskDataSource;
    private final Executor executor;

    public TaskModelFactory(TaskDataRepository  taskDataSource, Executor executor) {
        this.taskDataSource = taskDataSource;
        this.executor = executor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TaskViewModel.class)) {
            return (T) new TaskViewModel(taskDataSource, executor);
        }
        throw new IllegalArgumentException("Unknown TaskViewModel class");
    }
}
