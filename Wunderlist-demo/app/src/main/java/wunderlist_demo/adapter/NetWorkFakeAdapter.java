package demo.wunderlist.alfredo_cerezo.wunderlist_demo.adapter;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.fake_networkproxy.FakeNetworkAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;

/**
 * Created by jachu on 20/11/15.
 * <p>
 * Adapter to implement a FAKE network connection, this is an example of how it will done
 */
public class NetWorkFakeAdapter implements TaskGateway {

    private FakeNetworkAdapter mFakeNetworkAdapter;

    @Override
    public void createTask(Task task, Observer<Void> observer) {
        mFakeNetworkAdapter.createTask(task);
        observer.onFinished(null);
    }

    @Override
    public void updateTask(Task task, Observer<Void> observer) {
        mFakeNetworkAdapter.updateTask(task);
        observer.onFinished(null);
    }

    @Override
    public void deleteTask(Task task, Observer<Void> observer) {
        mFakeNetworkAdapter.deleteTask(task);
        observer.onFinished(null);
    }

    @Override
    public void getAllTasks(Observer<List<Task>> observer) {
        List<Task> tasks = mFakeNetworkAdapter.getAllTask();
        observer.onFinished(tasks);

    }
}
