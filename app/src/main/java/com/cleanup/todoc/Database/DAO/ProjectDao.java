package com.cleanup.todoc.Database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Project;

import java.util.List;

@Dao
public class ProjectDao {

    @Query("SELECT * FROM Project WHERE id = :userId")
    LiveData<List<Project>> getItems(long userId);


    @Insert
    long insertProject(Project project);

    @Update
    int updateProject(Project project);

    @Query("DELETE FROM Item WHERE id = :itemId")
    int deleteItem(long itemId);
