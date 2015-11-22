package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases;

import javax.inject.Inject;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractors;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p/>
 * <p/>
 * This class implements the specific Business rules, in this case it implements the logic
 * adding a new task to the DB (or other repository which implements the TaskGateway interface).
 */
public class CreateTaskUseCase implements TaskInteractors.CreateTaskInteractor {

    private TaskGateway mTaskGateway;

    @Inject
    public CreateTaskUseCase(TaskGateway taskGateway) {
        this.mTaskGateway = taskGateway;
    }


    @Override
    public void execute(Task task, Observer<Void> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer can't be null");
        }
        this.mTaskGateway.createTask(task, observer);
    }
}
