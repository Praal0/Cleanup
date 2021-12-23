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

import static androidx.room.OnConflictStrategy.REPLACE;

import android.database.Cursor;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM tasks")
    LiveData<List<Task>> getTasks();


    @Query("SELECT * FROM tasks WHERE id = :userId")
    Cursor getItemsWithCursor(long userId);


    @Insert(onConflict = REPLACE)
    void insertTask(Task task);

    @Delete
    void deleteTask(Task task);

}
