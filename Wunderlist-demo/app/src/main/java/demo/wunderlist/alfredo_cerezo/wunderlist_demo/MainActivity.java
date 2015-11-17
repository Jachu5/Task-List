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

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ApplicationWunderlist;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Observer;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.exceptions.WunderlistException;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.GetAllTaskInteractor;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        createTaskTest();
        getAllTaskTest();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void createTaskTest() {
        TaskInteractor.ParametrizedTaskInteractor createTaskInteractor = ((ApplicationWunderlist) getApplication()).getApplicationComponent().provideCreateTaskInteractor();
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
        GetAllTaskInteractor getAllTaskInteractor = ((ApplicationWunderlist) getApplication()).getApplicationComponent().provideGetAllTaskInteractor();
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
