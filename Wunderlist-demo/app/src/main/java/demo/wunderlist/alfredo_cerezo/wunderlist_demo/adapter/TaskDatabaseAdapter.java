package demo.wunderlist.alfredo_cerezo.wunderlist_demo.adapter;

import java.util.List;

import javax.inject.Inject;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database.DatabaseAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public class TaskDatabaseAdapter implements TaskGateway {

    private DatabaseAdapter mTaskDatabaseAdapter;

    @Inject
    public TaskDatabaseAdapter(DatabaseAdapter taskAdapter) {
        this.mTaskDatabaseAdapter = taskAdapter;
    }

    @Override
    public void createTask(Task task, Observer<Void> observer) {
        try {
            mTaskDatabaseAdapter.createTask(task);
            observer.onFinished(null);
        } catch (Exception exception) {
            observer.onError(new WunderlistException());
        }
    }

    @Override
    public void getAllTasks(Observer<List<Task>> observer) {
        try {
            List<Task> taskList = mTaskDatabaseAdapter.getAllTask();
            observer.onFinished(taskList);
        } catch (Exception exception) {
            observer.onError(new WunderlistException());
        }
    }
}
