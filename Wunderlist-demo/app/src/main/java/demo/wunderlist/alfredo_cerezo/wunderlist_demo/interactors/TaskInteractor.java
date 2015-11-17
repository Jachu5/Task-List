package demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public interface TaskInteractor {


    public interface UnparametrizedTaskInteractor {
        void execute(final Observer<Void> observer);
    }

    public interface ParametrizedTaskInteractor {
        void execute(Task task, final Observer<Void> observer);
    }


}
