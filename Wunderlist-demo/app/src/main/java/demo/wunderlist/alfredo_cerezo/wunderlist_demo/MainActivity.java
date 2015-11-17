package demo.wunderlist.alfredo_cerezo.wunderlist_demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.adapter.TaskAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database.TaskDatabaseAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor.Command;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor.CommandExecutor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.executor.ThreadCommandExecutor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.interators.CreateTaskUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.interators.GetAllTasksUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.GetAllTaskInteractor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractor;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createTask();
        getAllTask();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getAllTask() {
        final CommandExecutor mCommandExecutor = new ThreadCommandExecutor();
        TaskDatabaseAdapter databaseAdapter = new TaskDatabaseAdapter();
        TaskAdapter taskAdapter = new TaskAdapter(databaseAdapter);

        final GetAllTaskInteractor getAllTask = new GetAllTasksUseCase(taskAdapter);

        mCommandExecutor.run(new Command() {
            @Override
            public void run() {
                getAllTask.execute(new Observer<List<Task>>() {
                    @Override
                    public void onFinished(List<Task> result) {
                        Log.d(TAG, "List of tasks retrieed, size: " + result.size());
                    }

                    @Override
                    public void onError(WunderlistException exception) {
                        Log.e(TAG, "Error while retrieving list of tasks", exception);
                    }
                });
            }
        });
    }

    private void createTask() {
        final CommandExecutor mCommandExecutor = new ThreadCommandExecutor();
        TaskDatabaseAdapter databaseAdapter = new TaskDatabaseAdapter();
        TaskAdapter taskAdapter = new TaskAdapter(databaseAdapter);
        Task task = new Task();
        task.setCompleted(false);
        task.setContent("Blablabla");
        task.setOrder(1);
        task.setTaskId(12);
        final TaskInteractor createTask = new CreateTaskUseCase(taskAdapter, task);

        mCommandExecutor.run(new Command() {
            @Override
            public void run() {
                createTask.execute(new Observer<Void>() {
                    @Override
                    public void onFinished(Void result) {
                        Log.d(TAG, "Task created ");
                    }

                    @Override
                    public void onError(WunderlistException exception) {
                        Log.e(TAG, "Error while creating a task", exception);
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
