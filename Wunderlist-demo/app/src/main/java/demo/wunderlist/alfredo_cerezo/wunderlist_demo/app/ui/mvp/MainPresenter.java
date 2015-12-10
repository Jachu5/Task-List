package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.ui.mvp;

/**
 * Created by jachu on 19/11/15.
 * <p/>
 * Interface which defines the communication between  the View and the presenter in the MVP pattern
 */
public interface MainPresenter<T> {

    public void onResume();

    public void onAddTask(String taskString);

    public void onCheckBoxTouched(boolean checked, int position);

    public void onSwipeTask(int position);

    public void updateTask(T task);

    public void deleteTask(T task);

}