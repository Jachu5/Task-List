package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractors;

/**
 * Created by alfredocerezoluna on 19/11/15.
 */
public class DeleteTaskUseCase implements TaskInteractors.DeleteTaskInteractor {

    @Override
    public void execute(Task task, Observer<Void> observer) {

    }
}
