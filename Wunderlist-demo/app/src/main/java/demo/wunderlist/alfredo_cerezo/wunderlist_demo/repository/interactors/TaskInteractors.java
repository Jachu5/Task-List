package demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.interactors;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p/>
 * This class contains all the interactor from the application, maybe it was a bad choice to
 * join all interfaces inside a common one, is not clear for other developers, but the idea
 * was to join Create, Update and delete in a single one, no time to do it.
 */
public interface TaskInteractors {

    interface CreateTaskInteractor {
        void execute(Task task, final Observer<Void> observer);
    }

    interface UpdateTaskInteractor {
        void execute(Task task, final Observer<Void> observer);
    }

    interface DeleteTaskInteractor {
        void execute(Task task, final Observer<Void> observer);
    }

    interface GetAllTaskInteractor {
        void execute(final Observer<List<Task>> observer);
    }


}
