package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.animation;

import android.animation.ObjectAnimator;
import android.widget.ImageButton;

/**
 * Created by jachu on 22/11/15.
 */
public class AnimationFactory {

    public static ObjectAnimator getAddTaskCheckAnimationAppear(ImageButton checkButton) {
        ObjectAnimator objectAnimatorButton = ObjectAnimator.ofFloat(checkButton, "translationX", 0f, 400f);
        objectAnimatorButton.setDuration(1000);

        return objectAnimatorButton;
    }

    public static ObjectAnimator getAddTaskCheckAnimationDisappear(ImageButton checkButton) {
        ObjectAnimator objectAnimatorButton = ObjectAnimator.ofFloat(checkButton, "translationX", 0f, -400f);
        objectAnimatorButton.setDuration(1000);

        return objectAnimatorButton;
    }
}
