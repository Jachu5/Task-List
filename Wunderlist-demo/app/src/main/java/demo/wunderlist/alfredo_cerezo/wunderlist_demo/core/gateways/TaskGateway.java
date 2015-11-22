package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p/>
 * Interface for Task repository management, it works as boundary which transform the information
 * from the outside into the kind of information the application uses, and vice versa
 */
public interface TaskGateway {

    public void createTask(Task task, Observer<Void> observer);

    public void updateTask(Task task, Observer<Void> observer);

    public void deleteTask(Task task, Observer<Void> observer);

    public void getAllTasks(Observer<List<Task>> observer);
}
