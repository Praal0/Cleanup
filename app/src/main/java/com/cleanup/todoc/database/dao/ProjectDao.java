package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

@Dao
public interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Project project);

    @Query("SELECT * FROM project WHERE id = :id LIMIT 1")
    LiveData<Project> loadProjectById(long id);

    @Query("SELECT * from project")
    LiveData<List<Project>> loadAllProjects();

}
