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

    @Column(name = "taskId")
    @NotNull
    long mTaskId;

    @Column(name = "completed")
    @NotNull
    boolean mCompleted;

    @Column(name = "order")
    @NotNull
    int mOrder;

    @Column(name = "content")
    @NotNull
    String mContent;

    public TaskModel() {
        super();
    }

    public long getTaskId() {
        return mTaskId;
    }

    public void setTaskId(long mTaskId) {
        this.mTaskId = mTaskId;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean mCompleted) {
        this.mCompleted = mCompleted;
    }

    public int getOrder() {
        return mOrder;
    }

    public void setOrder(int mOrder) {
        this.mOrder = mOrder;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }
}
