package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.fake_networkproxy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by jachu on 20/11/15.
 * <p/>
 * FAKE Network connection
 */
public class FakeNetworkAdapter {

    private ArrayList<Task> mNetworkConnection;

    public FakeNetworkAdapter() {
        mNetworkConnection = new ArrayList();
    }

    public void deleteTask(Task task) {

    }

    public void updateTask(Task task) {

    }

    public void createTask(Task task) {

    }

    public List<Task> getAllTask() {
        return mNetworkConnection;
    }
}
