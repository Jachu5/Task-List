package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui.mvp;

/**
 * Created by jachu on 19/11/15.
 */
public interface MainPresenter<T> {

    public void onResume();

    public void onAddTask(String taskString, int position);

    public void onCheckBoxTouched(boolean checked, int position);

    public void onSwipeTask(int position);

    public void updateTask(T task);

    public void deleteTask(T task);

}