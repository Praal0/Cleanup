package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

public class TaskDataRepository {
    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDao) { this.taskDao = taskDao; }

    // --- GET ---

    public LiveData<Task> getTask(long userId){ return this.taskDao.loadTaskById(userId); }

    // --- CREATE ---

    public void createItem(Task task){ taskDao.insertTasks(task); }

    // --- DELETE ---
    public void deleteItem(Task task){ taskDao.deleteTasks(task); }

    // --- UPDATE ---
    public void updateItem(Task task){ taskDao.updateTasks(task); }
}
