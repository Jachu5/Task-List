package demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.interators.CreateTaskUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.interators.GetAllTasksUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.GetAllTaskInteractor;

/**
 * Created by jachu on 17/11/15.
 */
@Module(includes = TaskModule.class)
public class InteractorsModule {

    @Provides
    @Singleton
    GetAllTaskInteractor provideGetAllTaskInteractor(GetAllTasksUseCase useCase) {
        return useCase;
    }

    @Provides
    @Singleton
    TaskInteractor.ParametrizedTaskInteractor provideCreateTaskInteractor(CreateTaskUseCase useCase) {
        return useCase;
    }
}