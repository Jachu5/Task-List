package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.animation.AnimationFactory;

/**
 * Created by jachu on 22/11/15.
 */
public class AddTaskButton extends ImageButton {

    public AddTaskButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setHide() {
        this.setVisibility(View.GONE);

    }

    public void setVisible() {
        this.setVisibility(View.VISIBLE);
    }

    public void makeDisapear() {
        AnimationFactory.getAddTaskCheckAnimationDisappear(this).start();
    }

    public void makeAppear() {
        AnimationFactory.getAddTaskCheckAnimationDisappear(this).start();
    }


}
