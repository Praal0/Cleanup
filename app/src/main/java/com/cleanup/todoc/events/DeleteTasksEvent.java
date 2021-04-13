package com.cleanup.todoc.events;

import com.cleanup.todoc.model.Task;

public class DeleteTasksEvent {
    public Task task;

    /**
     * Constructor
     * @param task
     */

    public DeleteTasksEvent(Task task){this.task = task;}
}
