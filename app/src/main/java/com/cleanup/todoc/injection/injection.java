package com.cleanup.todoc.injection;

import android.content.Context;

import com.cleanup.todoc.database.SaveMyTripDatabase;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class injection {
    public static ProjectDataRepository provideItemDataSource(Context context) {
        SaveMyTripDatabase database = SaveMyTripDatabase.getInstance(context);
        return new ProjectDataRepository(database.projectDao());
    }

    public static TaskDataRepository provideUserDataSource(Context context) {
        SaveMyTripDatabase database = SaveMyTripDatabase.getInstance(context);
        return new TaskDataRepository(database.taskDao());
    }

    public static Executor provideExecutor(){ return Executors.newSingleThreadExecutor(); }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        ProjectDataRepository dataSourceProject = provideItemDataSource(context);
        TaskDataRepository dataSourceTask = provideUserDataSource(context);
        Executor executor = provideExecutor();
        return new ViewModelFactory(dataSourceProject, dataSourceTask, executor);
    }
}
