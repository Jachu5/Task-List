package demo.wunderlist.alfredo_cerezo.wunderlist_demo;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ApplicationWunderlist;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui.TaskListAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractors;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        initList();
        createTaskTest();
        getAllTaskTest();
    }

    private void initList() {
        //RecyclerView
        RecyclerView list = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<Task> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Task task = new Task();
            task.setContent("blebleble");
            data.add(task);
        }

        TaskListAdapter.HeaderListener listener = new TaskListAdapter.HeaderListener() {
            @Override
            public void onTaskAddingTouch() {
                Log.d(TAG, "Header task touhed");
            }

            @Override
            public void onAddTaskTouch(String taskText) {
                Log.d(TAG, "Header add touhed");
            }
        };
        TaskListAdapter adapter = new TaskListAdapter(data, listener);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        list.setItemAnimator(new DefaultItemAnimator());
    }


    private void initToolBar() {
        //App bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setTitle("Wunderlist");

        //CollapsingToolbarLayout
        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctlLayout);
        ctlLayout.setTitle(getString(R.string.app_name));
    }

    private void createTaskTest() {
        TaskInteractors.CreateTaskInteractor createTaskInteractor = ((ApplicationWunderlist) getApplication()).getApplicationComponent().provideCreateTaskInteractor();
        Task task = new Task();
        task.setCompleted(true);
        task.setContent("Blebleble");
        task.setOrder(1);
        task.setTaskId(12);
        createTaskInteractor.execute(task, new Observer<Void>() {
            @Override
            public void onFinished(Void result) {
                Log.d(TAG, "Task created");
            }

            @Override
            public void onError(WunderlistException exception) {
                Log.e(TAG, "Finished task creation with error", exception);
            }
        });
    }

    private void getAllTaskTest() {
        TaskInteractors.GetAllTaskInteractor getAllTaskInteractor = ((ApplicationWunderlist) getApplication()).getApplicationComponent().provideGetAllTaskInteractor();
        getAllTaskInteractor.execute(new Observer<List<Task>>() {
            @Override
            public void onFinished(List<Task> result) {
                Log.d(TAG, "Finished");
            }

            @Override
            public void onError(WunderlistException exception) {
                Log.e(TAG, "Finished with error", exception);
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
