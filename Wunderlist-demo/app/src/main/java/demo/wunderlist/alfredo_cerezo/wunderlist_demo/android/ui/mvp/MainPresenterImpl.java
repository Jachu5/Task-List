package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui.mvp;

import android.content.Context;
import android.util.Log;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ApplicationWunderlist;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor.Command;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor.CommandExecutor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractors;

/**
 * Created by jachu on 19/11/15.
 */
public class MainPresenterImpl implements MainPresenter<Task> {

    public static final String TAG = "MainPresenterImpl";

    private final MainView mMainView;
    private final CommandExecutor mCommandExecutor;
    private final TaskInteractors.CreateTaskInteractor mCreateTaskInteractor;
    private final TaskInteractors.UpdateTaskInteractor mUpdateTaskInteractor;
    private final TaskInteractors.DeleteTaskInteractor mDeleteTaskInteractor;
    private final TaskInteractors.GetAllTaskInteractor mGetAllTaskInteractor;


    public MainPresenterImpl(MainView mainView, Context context) {
        mMainView = mainView;
        mCommandExecutor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideCommandExecutor();
        mCreateTaskInteractor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideCreateTaskInteractor();
        mUpdateTaskInteractor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideUpdateTaskInteractor();
        mGetAllTaskInteractor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideGetAllTaskInteractor();
        mDeleteTaskInteractor = ((ApplicationWunderlist) context)
                .getApplicationComponent().provideDeleteTaskInteractor();

    }

    @Override
    public void onResume() {
        getAllTask();
    }

    private void getAllTask() {
        mCommandExecutor.run(new Command() {
            @Override
            public void run() {
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
        });

    }

    @Override
    public void onAddTask(final String taskString, int position) {
        String id = generateUniqueId();
        final Task task = createTask(taskString, position, id);

        mCommandExecutor.run(new Command() {
            @Override
            public void run() {
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

    @Override
    public void updateTask(final Task task) {
        mCommandExecutor.run(new Command() {
            @Override
            public void run() {
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
        });

    }

    @Override
    public void onSwipeTask(int position) {
        mMainView.onSwipeTask(position);
    }

    @Override
    public void deleteTask(final Task task) {
        mCommandExecutor.run(new Command() {
            @Override
            public void run() {
                mDeleteTaskInteractor.execute(task, new Observer<Void>() {
                    @Override
                    public void onFinished(Void result) {
                        Log.i(TAG, "task with ID:" + task.getId() + "has been deleted");
                    }

                    @Override
                    public void onError(WunderlistException exception) {

                    }
                });
            }
        });

    }

    public static final int ID_LENGTH = 10;

    public String generateUniqueId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }

    private Task createTask(String taskString, int position, String id) {
        Task task = new Task();
        task.setId(id);
        task.setCompleted(false);
        task.setPosition(position);
        task.setContent(taskString);
        return task;
    }
}
