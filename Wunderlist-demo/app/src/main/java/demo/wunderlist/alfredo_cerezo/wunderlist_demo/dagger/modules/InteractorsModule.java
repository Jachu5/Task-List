package demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases.CreateTaskUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases.DeleteTaskUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases.GetAllTasksUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.use_cases.UpdateTaskUseCase;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractors;

/**
 * Created by jachu on 17/11/15.
 */
@Module(includes = TaskModule.class)
public class InteractorsModule {

    @Provides
    @Singleton
    TaskInteractors.GetAllTaskInteractor provideGetAllTaskInteractor(GetAllTasksUseCase useCase) {
        return useCase;
    }

    @Provides
    @Singleton
    TaskInteractors.UpdateTaskInteractor provideUpdateTaskInteractor(UpdateTaskUseCase useCase) {
        return useCase;
    }

    @Provides
    @Singleton
    TaskInteractors.CreateTaskInteractor provideCreateTaskInteractor(CreateTaskUseCase useCase) {
        return useCase;
    }

    @Provides
    @Singleton
    TaskInteractors.DeleteTaskInteractor provideCreateTaskInteractor(DeleteTaskUseCase useCase) {
        return useCase;
    }
}
