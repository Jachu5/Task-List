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
 * <p/>
 * This adapter works to serve as a joint between the useCase and the the repository,
 * the main advantage of this approach is that it really easy to maintain and change,
 * lets suppose we would like to change our repository of tasks, and use a network connection,
 * or any other sotrage device, we only need to implemtn the Gateway and using DI (Dagger2),
 * provide the new adapter to the UseCase.
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
    public void updateTask(Task task, Observer<Void> observer) {
        try {
            mTaskDatabaseAdapter.updateTask(task);
            observer.onFinished(null);
        } catch (Exception exception) {
            observer.onError(new WunderlistException());
        }
    }

    @Override
    public void deleteTask(Task task, Observer<Void> observer) {
        try {
            mTaskDatabaseAdapter.deleteTask(task);
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
