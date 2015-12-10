package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases;

import javax.inject.Inject;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.interactors.TaskInteractors;

/**
 * Created by alfredocerezoluna on 19/11/15.
 * <p/>
 * This class implements the specific Business rules, in this case it implements the logic
 * deleting a specific task from the DB (or other repository which implements the TaskGateway interface).
 */
public class DeleteTaskUseCase implements TaskInteractors.DeleteTaskInteractor {

    private TaskGateway mTaskGateway;

    @Inject
    public DeleteTaskUseCase(TaskGateway gateway) {
        this.mTaskGateway = gateway;
    }

    @Override
    public void execute(Task task, Observer<Void> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer can't be null");
        }
        this.mTaskGateway.deleteTask(task, observer);
    }
}
