package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases;

import java.util.List;

import javax.inject.Inject;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.interactors.TaskInteractors;

/**
 * Created by jachu on 17/11/15.
 * <p/>
 * This class implements the specific Business rules, in this case it implements the logic
 * retrieving all tasks from the DB (or other repository which implements the TaskGateway interface).
 */
public class GetAllTasksUseCase implements TaskInteractors.GetAllTaskInteractor {

    private TaskGateway mTaskGateway;

    @Inject
    public GetAllTasksUseCase(TaskGateway taskGateway) {
        this.mTaskGateway = taskGateway;
    }

    @Override
    public void execute(Observer<List<Task>> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer can't be null");
        }

        this.mTaskGateway.getAllTasks(observer);
    }
}
