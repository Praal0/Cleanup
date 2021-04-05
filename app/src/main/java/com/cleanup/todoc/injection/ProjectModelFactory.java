package com.cleanup.todoc.injection;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cleanup.todoc.ViewModel.ProjectViewModel;
import com.cleanup.todoc.ViewModel.TaskViewModel;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.concurrent.Executor;

public class ProjectModelFactory implements ViewModelProvider.Factory{

    private final ProjectDataRepository projectDataRepository;
    private final Executor executor;

    public ProjectModelFactory(ProjectDataRepository  projectDataSource, Executor executor) {
        this.projectDataRepository = projectDataSource;
        this.executor = executor;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TaskViewModel.class)) {
            return (T) new ProjectViewModel(projectDataRepository, executor);
        }
        throw new IllegalArgumentException("Unknown ProjectViewModel class");
    }
}
