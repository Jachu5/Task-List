package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.components.ApplicationComponent;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.components.DaggerApplicationComponent;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.modules.InteractorsModule;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public class ApplicationWunderlist extends Application {

    private ApplicationComponent mApplicationComponentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
        initInjection();
    }

    private void initInjection() {
        mApplicationComponentComponent = DaggerApplicationComponent.builder().interactorsModule(new InteractorsModule()).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponentComponent;
    }
}
