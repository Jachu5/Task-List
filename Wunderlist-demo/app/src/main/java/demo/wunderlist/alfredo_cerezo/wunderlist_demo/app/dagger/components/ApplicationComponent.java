package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.executor.CommandExecutor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.modules.ApplicationModule;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.dagger.modules.InteractorsModule;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.interactors.TaskInteractors;

/**
 * Created by jachu on 17/11/15.
 */
@Singleton
@Component(modules = {InteractorsModule.class, ApplicationModule.class})
public interface ApplicationComponent {

    CommandExecutor provideCommandExecutor();

    TaskInteractors.GetAllTaskInteractor provideGetAllTaskInteractor();

    TaskInteractors.CreateTaskInteractor provideCreateTaskInteractor();

    TaskInteractors.UpdateTaskInteractor provideUpdateTaskInteractor();

    TaskInteractors.DeleteTaskInteractor provideDeleteTaskInteractor();
}
