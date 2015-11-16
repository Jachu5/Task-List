package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.interators;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractor;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public class CreateTaskUseCase implements TaskInteractor {

    private TaskGateway mTaskGateway;
    private Task mTask;

    public CreateTaskUseCase(TaskGateway taskGateway, Task task) {
        this.mTaskGateway = taskGateway;
    }


    @Override
    public void execute(Observer<Void> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer can't be null");
        }
        this.mTaskGateway.createTask(mTask, observer);
    }
}
