package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui.mvp;

import android.content.Context;
import android.util.Log;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ApplicationWunderlist;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractors;

/**
 * Created by jachu on 19/11/15.
 */
public class MainPresenterImpl implements MainPresenter<Task> {

    public static final String TAG = "MainPresenterImpl";

    private MainView mMainView;
    private TaskInteractors.CreateTaskInteractor mCreateTaskInteractor;
    private TaskInteractors.UpdateTaskInteractor mUpdateTaskInteractor;
    private TaskInteractors.GetAllTaskInteractor mGetAllTaskInteractor;

    public MainPresenterImpl(MainView mainView, Context context) {
        mMainView = mainView;
        mCreateTaskInteractor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideCreateTaskInteractor();
        mUpdateTaskInteractor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideUpdateTaskInteractor();
        mGetAllTaskInteractor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideGetAllTaskInteractor();

    }

    @Override
    public void onResume() {
        getAllTask();
    }

    private void getAllTask() {
        mGetAllTaskInteractor.execute(new Observer<List<Task>>() {
            @Override
            public void onFinished(List<Task> result) {
                mMainView.setItems(result);
                Log.d(TAG, "Finished");
            }

            @Override
            public void onError(WunderlistException exception) {
                Log.e(TAG, "Finished with error", exception);
            }
        });
    }

    @Override
    public void onAddTask(final String taskString) {
        final Task task = createTask(taskString);
        mCreateTaskInteractor.execute(task, new Observer<Void>() {
            @Override
            public void onFinished(Void result) {
                Log.d(TAG, "Task created");
                mMainView.addTask(task);
            }

            @Override
            public void onError(WunderlistException exception) {
                Log.e(TAG, "Finished task creation with error", exception);
            }
        });
    }

    @Override
    public void onCheckBoxTouched(boolean checked, int position) {
        //TODO delete task
        if (checked) {
            mMainView.onCheckTask(position);
        } else {
            mMainView.onUnCheckTask(position);
        }
    }

    public void updateTask(final Task task) {
        mUpdateTaskInteractor.execute(task, new Observer<Void>() {
            @Override
            public void onFinished(Void result) {
                Log.i(TAG, "task with ID:" + task.getId() + "has been added");
            }

            @Override
            public void onError(WunderlistException exception) {
                Log.e(TAG, "Finished task updating with error", exception);
            }
        });
    }

    private Task createTask(String taskString) {
        Task task = new Task();
        task.setCompleted(false);
        task.setContent(taskString);
        return task;
    }
}
