package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui.mvp;

/**
 * Created by alfredocerezoluna on 19/11/15.
 */
public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
