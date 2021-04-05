package com.cleanup.todoc.ViewModel;

import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.concurrent.Executor;

public class ProjectViewModel extends ViewModel {

    // REPOSITORIES
    private final ProjectDataRepository ProjectDataSource;
    private final Executor executor;

    // DATA

    public ProjectViewModel(ProjectDataRepository projectDataSource, Executor executor) {
        this.ProjectDataSource = projectDataSource;
        this.executor = executor;
    }

    // -------------
    // FOR PROJECT
    // -------------

    public void getAllProject() {
        executor.execute(() -> {
            ProjectDataSource.getAllProjects();
        });
    }
}