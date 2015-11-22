package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p/>
 * Wunderlist Database database definition, since my experience with SQLite is
 * not as extensive as I wpuld like, I decide to leverage this logic to a
 * ORM library, in this case DBFlow, it works really well and is already tested
 * by the community.
 */

@com.raizlabs.android.dbflow.annotation.Database(name = Database.NAME, version = Database.VERSION)
public class Database {

    public static final String NAME = "WunderlistTasks";
    public static final int VERSION = 1;

}
