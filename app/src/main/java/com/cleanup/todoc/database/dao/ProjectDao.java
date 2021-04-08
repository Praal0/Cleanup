package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ProjectDao {
    @Query("SELECT * FROM projects")
    LiveData<List<Project>> getProjects();

    @Insert(onConflict = REPLACE)
    void insertProjects(Project... projects);

}
