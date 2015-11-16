package demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public interface TaskInteractor {

    /**
     * Use case execution operation
     *
     * @param observer use case observer
     */
    void execute(final Observer<Void> observer);


}
