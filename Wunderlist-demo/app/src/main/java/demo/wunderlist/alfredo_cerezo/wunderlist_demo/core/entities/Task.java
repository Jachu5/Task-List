package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities;

/**
 * Temporary class
 * Created by alfredocerezoluna on 16/11/15.
 */
//TODO implement builder pattern
public class Task {
    private long mTaskId;
    private boolean mCompleted;
    private int mOrder;
    private String mContent;

    public Task(){

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
