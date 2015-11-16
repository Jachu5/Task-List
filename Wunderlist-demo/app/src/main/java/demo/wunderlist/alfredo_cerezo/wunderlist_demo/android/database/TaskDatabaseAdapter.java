package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public class TaskDatabaseAdapter {

    public TaskDatabaseAdapter() {

    }

    public void createTask(Task task) {
        TaskModel taskModel = new TaskModel();
        taskModel.insert();
    }

}
