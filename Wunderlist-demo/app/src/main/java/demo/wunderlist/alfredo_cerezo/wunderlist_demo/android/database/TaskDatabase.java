package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p/>
 * Wunderlist Database database definition
 */

@Database(name = TaskDatabase.NAME, version = TaskDatabase.VERSION)
public class TaskDatabase {

    public static final String NAME = "WunderlistTasks";
    public static final int VERSION = 1;

}
