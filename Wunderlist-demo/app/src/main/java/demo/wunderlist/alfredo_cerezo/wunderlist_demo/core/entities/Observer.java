package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p/>
 * Interface for classes that need an observer without result arguments
 */


public interface Observer<T> {
    /**
     * Callback to be invoked when the request execution finishes with success
     *
     * @param result Object to be returned as result of the execution
     */
    void onFinished(T result);

    /**
     * Callback to be invoked when the request execution finishes with error
     *
     * @param exception error thrown by the execution
     */
    void onError(WunderlistException exception);
}

