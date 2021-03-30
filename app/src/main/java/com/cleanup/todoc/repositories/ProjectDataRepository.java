package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectDataRepository {
    private final ProjectDao projectDao;
    private LiveData<List<Project>> allProjects;



    public ProjectDataRepository(ProjectDao projectDao){
        this.projectDao = projectDao;
        allProjects = this.projectDao.loadAllProjects();
    }

    // --- GET PROJECT ---
    public LiveData<Project> getProject(long projectId) { return this.projectDao.loadProjectById(projectId); }


    public LiveData<List<Project>> getAllProjects() {
        return allProjects;
    }






}
