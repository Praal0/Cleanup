package com.cleanup.todoc.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertTasks(Task... tasks);

    @Update
    public void updateTasks(Task... tasks);

    @Delete
    public void deleteTasks(Task... tasks);

    @Query("SELECT * from Task")
    public LiveData<List<Task>> loadAllTasks();

    @Query("SELECT * FROM Task WHERE id = :id LIMIT 1")
    public LiveData<Task> loadTaskById(long id);

}
