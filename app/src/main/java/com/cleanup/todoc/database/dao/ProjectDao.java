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
    void insert(Project project);

    @Query("DELETE FROM Project")
    void deleteAll();

    @Query("SELECT * FROM Project WHERE id = :id LIMIT 1")
    public LiveData<Project> loadProjectById(long id);

    @Query("SELECT * from Project")
    LiveData<List<Project>> loadAllProjects();

}
