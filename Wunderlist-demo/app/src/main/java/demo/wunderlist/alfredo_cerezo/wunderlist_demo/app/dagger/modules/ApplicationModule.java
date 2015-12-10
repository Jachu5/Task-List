package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.executor.CommandExecutor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.executor.ThreadCommandExecutor;

/**
 * Created by jachu on 17/11/15.
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    CommandExecutor provideCommandExecutor() {
        return new ThreadCommandExecutor();
    }
}
