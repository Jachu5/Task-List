package demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by jachu on 17/11/15.
 */
public interface GetAllTaskInteractor {

    /**
     * Use case execution operation
     *
     * @param observer use case observer
     */
    void execute(final Observer<List<Task>> observer);
}
