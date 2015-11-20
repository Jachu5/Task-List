package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Temporary class
 * Created by alfredocerezoluna on 16/11/15.
 */
//TODO implement builder pattern
public class Task implements Comparable<Task> {

    private String mId;
    private int mPosition;
    private boolean mCompleted;
    private String mContent;

    public Task() {

    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        this.mPosition = position;
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


    @Override
    public int compareTo(Task task) {
        int taskPosition = task.getPosition();
        int cmp = mPosition > taskPosition ? +1 : mPosition < taskPosition ? -1 : 0;

        return cmp;
    }
}
