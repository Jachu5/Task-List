package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.ui.mvp;

import java.util.List;

/**
 * Created by jachu on 19/11/15.
 * <p/>
 * Interface to communicate the Presenter and the View in the MVP pattern
 */
public interface MainView<T> {


    public void onSwipeTask(int position);

    public void onCheckTask(int position);

    public void onUnCheckTask(int position);

    public void addTask(T task);

    public void setItems(List<T> items);


}