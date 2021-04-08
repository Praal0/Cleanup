package com.cleanup.todoc.ViewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class ProjectViewModel extends ViewModel {

    // REPOSITORIES
    private final ProjectDataRepository ProjectDataSource;
    private final Executor executor;

    @Nullable
    private LiveData<List<Project>> mProjects;

    // DATA

    public ProjectViewModel(ProjectDataRepository projectDataSource, Executor executor) {
        this.ProjectDataSource = projectDataSource;
        this.executor = executor;
    }

    // -------------
    // FOR PROJECT
    // -------------

    public void init() {
        if (mProjects == null)
            mProjects = ProjectDataSource.getProjects();
    }

    @Nullable
    public LiveData<List<Project>> getProjects() {
        return mProjects;
    }
}