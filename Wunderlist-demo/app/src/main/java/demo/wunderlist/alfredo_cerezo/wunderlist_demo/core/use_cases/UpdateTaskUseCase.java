package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases;

import javax.inject.Inject;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.interactors.TaskInteractors;

/**
 * Created by jachu on 19/11/15.
 *
 * This class implements the specific Business rules, in this case it implements the logic
 * in the updating the DB (or other repository which implements the TaskGateway interface) scenario.
 */
public class UpdateTaskUseCase implements TaskInteractors.UpdateTaskInteractor {

    private TaskGateway mTaskGateway;

    @Inject
    public UpdateTaskUseCase(TaskGateway taskGateway) {
        this.mTaskGateway = taskGateway;
    }

    @Override
    public void execute(Task task, Observer<Void> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer can't be null");
        }
        mTaskGateway.updateTask(task, observer);
    }
}
