package demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.adapter.TaskDatabaseAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database.DatabaseAdapter;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.gateways.TaskGateway;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.interators.GetAllTasksUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.GetAllTaskInteractor;

/**
 * Created by jachu on 17/11/15.
 * <p/>
 * Class to provide taskRelated dependencies
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

    @Provides
    @Singleton
    GetAllTaskInteractor provideGetAllTaskInteractor(GetAllTasksUseCase usecase) {
        return usecase;
    }
}
