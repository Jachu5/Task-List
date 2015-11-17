package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.components.DaggerTaskComponent;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.components.TaskComponent;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.modules.TaskModule;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public class ApplicationWunderlist extends Application {

    private TaskComponent mTaskComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        initInjection();
    }

    private void initInjection() {
        mTaskComponent = DaggerTaskComponent.builder().taskModule(new TaskModule()).build();
    }

    public TaskComponent getTaskComponent() {
        return mTaskComponent;
    }
}
