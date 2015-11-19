package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */

@Table(databaseName = Database.NAME)
public class TaskModel extends BaseModel {

    @Column(name = "id")
    @PrimaryKey(autoincrement = true)
    @NotNull
    long mId;

    @Column(name = "completed")
    @NotNull
    boolean mCompleted;

    @Column(name = "content")
    @NotNull
    String mContent;

    public TaskModel() {
        super();
    }

    public long getId() {
        return mId;
    }

    public void setId(long mTaskId) {
        this.mId = mTaskId;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean mCompleted) {
        this.mCompleted = mCompleted;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }
}
