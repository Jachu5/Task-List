package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.interators;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.GetAllTaskInteractor;

/**
 * Created by jachu on 17/11/15.
 */
public class GetAllTasksUseCase implements GetAllTaskInteractor {

    private TaskGateway mTaskGateway;

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
