package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor;

/**
 * Created by jachu on 16/11/15.
 *
 * Interface to be implemented by the interators
 */
public interface CommandExecutor {
    /**
     * Execute an interactor command
     * @param command
     */
    void run(final Command command);
}
