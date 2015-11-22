package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui.mvp;

import android.content.Context;
import android.util.Log;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ApplicationWunderlist;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor.Command;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor.CommandExecutor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.TaskFactory;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractors;

/**
 * Created by jachu on 19/11/15.
 * <p/>
 * This class works as the Presenter, both in the MVP pattern and in the Architecture,
 * it holds the interactors which executes the business logic of the application
 */
public class MainPresenterImpl implements MainPresenter<Task> {

    private static final String TAG = "MainPresenterImpl";

    private final MainView mMainView;
    private final CommandExecutor mCommandExecutor;
    private final TaskInteractors.CreateTaskInteractor mCreateTaskInteractor;
    private final TaskInteractors.UpdateTaskInteractor mUpdateTaskInteractor;
    private final TaskInteractors.DeleteTaskInteractor mDeleteTaskInteractor;
    private final TaskInteractors.GetAllTaskInteractor mGetAllTaskInteractor;

    private int mNumberOfTask;


    public MainPresenterImpl(MainView mainView, Context context) {
        mMainView = mainView;
        mNumberOfTask = 0;
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
                        mNumberOfTask = result.size();
                        mMainView.setItems(result);
                        Log.d(TAG, "Finished, list size: " + mNumberOfTask);
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
    public void onAddTask(final String taskString) {

        final Task task = TaskFactory.createTaskWithNoId(false, taskString);

        mCommandExecutor.run(new Command() {
            @Override
            public void run() {
                mCreateTaskInteractor.execute(task, new Observer<Void>() {
                    @Override
                    public void onFinished(Void result) {
                        mNumberOfTask++;
                        Log.d(TAG, "Task created: " + mNumberOfTask);
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
                        mNumberOfTask--;
                        Log.i(TAG, "task with ID:" + task.getId() + "has been deleted, number of tasks:" + mNumberOfTask);
                    }

                    @Override
                    public void onError(WunderlistException exception) {

                    }
                });
            }
        });

    }
}
