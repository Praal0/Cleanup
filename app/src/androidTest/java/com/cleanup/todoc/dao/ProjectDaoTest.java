package com.cleanup.todoc.dao;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.cleanup.todoc.iteraction.LiveDataTestUtil;
import com.cleanup.todoc.database.TodocDatabase;
import com.cleanup.todoc.model.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class ProjectDaoTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TodocDatabase database;
    private Project[] projects = Project.getAllProjects();


    @Before
    public void initDatabase()  {
        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getTargetContext(),
                TodocDatabase.class)
                .allowMainThreadQueries()
                .build();
        this.database.projectDao().insertProjects(this.projects);

    }

    @After
    public void closeDatabase() {
        this.database.close();
    }

    @Test
    public void insertAndGetProject() throws InterruptedException {
        List<Project> projects = LiveDataTestUtil.getValue(this.database.projectDao().getProjects());
        assertFalse(projects.isEmpty());
        assertEquals(3,projects.size());

        assertEquals(projects.get(0).getId(),this.projects[0].getId());
        assertEquals(projects.get(0).getName(),this.projects[0].getName());
        assertEquals(projects.get(0).getColor(),this.projects[0].getColor());

        assertEquals(projects.get(1).getId(),this.projects[1].getId());
        assertEquals(projects.get(1).getName(),this.projects[1].getName());
        assertEquals(projects.get(1).getColor(),this.projects[1].getColor());

        assertEquals(projects.get(2).getId(),this.projects[2].getId());
        assertEquals(projects.get(2).getName(),this.projects[2].getName());
        assertEquals(projects.get(2).getColor(),this.projects[2].getColor());

    }



}
