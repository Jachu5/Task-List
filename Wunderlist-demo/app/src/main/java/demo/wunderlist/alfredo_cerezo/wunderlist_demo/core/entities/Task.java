package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities;

/**
 * Temporary class
 * Created by alfredocerezoluna on 16/11/15.
 */
//TODO implement builder pattern
public class Task {
    private long mId;
    private boolean mCompleted;
    private String mContent;

    public Task() {

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
