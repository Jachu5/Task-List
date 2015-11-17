package demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.modules.InteractorsModule;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.TaskInteractor;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.GetAllTaskInteractor;

/**
 * Created by jachu on 17/11/15.
 */
@Singleton
@Component(modules = {InteractorsModule.class})
public interface ApplicationComponent {
    GetAllTaskInteractor provideGetAllTaskInteractor();

    TaskInteractor.ParametrizedTaskInteractor provideCreateTaskInteractor();
}
