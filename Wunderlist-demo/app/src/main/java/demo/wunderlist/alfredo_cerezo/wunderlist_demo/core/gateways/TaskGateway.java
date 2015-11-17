package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p>
 * Interface for Tsak repository management
 */
public interface TaskGateway {

    /**
     * Repository operation to create a new task, add the new task to the reposiroty
     *
     * @param task,     DTO containing the basic informarion to be stored
     * @param observer, observer which notifies weather the action has been completed, or an error has been ocurred
     */
    public void createTask(Task task, Observer<Void> observer);

    public void getAllTasks(Observer<List<Task>> observer);
}
