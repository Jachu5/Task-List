package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.adapter.TaskDatabaseAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.database.DatabaseAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;

/**
 * Created by jachu on 17/11/15.
 * <p/>
 * Class to provide taskRelated dependencies, this is very suitable for testing since it only needs to
 * define a new provider with a fake repositories.
 * i.e: TaskGateway provideDatabaseTaskGateway(FakeTaskDatabaseAdapter adapter) { return adapter; }
 * or maybe a NetWork based TaskGateway
 */
@Module
public class TaskModule {

    @Provides
    @Singleton
    DatabaseAdapter provideDatabaseAdapter() {
        return new DatabaseAdapter();
    }

    @Provides
    @Singleton
    TaskDatabaseAdapter provideTaskDatabaseAdapter(DatabaseAdapter databaseAdapter) {
        return new TaskDatabaseAdapter(databaseAdapter);
    }

    @Provides
    @Singleton
    TaskGateway provideDatabaseTaskGateway(TaskDatabaseAdapter adapter) {
        return adapter;
    }


}
