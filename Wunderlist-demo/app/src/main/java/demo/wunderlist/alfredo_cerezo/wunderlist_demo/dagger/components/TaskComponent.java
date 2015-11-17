package demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.dagger.modules.TaskModule;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.interactors.GetAllTaskInteractor;

/**
 * Created by jachu on 17/11/15.
 */
@Singleton
@Component(modules = {TaskModule.class})
public interface TaskComponent {
    GetAllTaskInteractor provideGetAllTaskInteractor();
}
