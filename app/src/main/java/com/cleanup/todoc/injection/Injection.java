package com.cleanup.todoc.injection;

import android.content.Context;

import com.cleanup.todoc.database.SaveMyTripDatabase;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Injection {

    public static ProjectDataRepository provideProjectDataSource(Context context) {
        SaveMyTripDatabase database = SaveMyTripDatabase.getInstance(context);
        return new ProjectDataRepository(database.projectDao());
    }

    public static TaskDataRepository provideTaskDataSource(Context context) {
        SaveMyTripDatabase database = SaveMyTripDatabase.getInstance(context);
        return new TaskDataRepository(database.taskDao());
    }

    public static Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    public static TaskModelFactory provideViewModelFactory(Context context) {
        ProjectDataRepository projectDataSource = provideProjectDataSource(context);
        TaskDataRepository taskDataSource = provideTaskDataSource(context);
        Executor executor = provideExecutor();
        return new TaskModelFactory(projectDataSource, taskDataSource, executor);
    }

}
