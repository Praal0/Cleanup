package com.cleanup.todoc.events;

import com.cleanup.todoc.model.Task;

public class AddTasksEvent {
    public Task task;

    /**
     * Constructor
     * @param task
     */

    public AddTasksEvent(Task task){this.task = task;}
}
