package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public class ApplicationWunderlist extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
