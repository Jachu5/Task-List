/*
 * Copyright (C) 2015 Paul Burke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo.wunderlist.alfredo_cerezo.wunderlist_demo.app.ui.swipw_and_move;

/**
 * Created by alfredocerezoluna on 19/11/15.
 * <p/>
 * Interface to communicate the model and the helper class for swiping and moving elements,
 * it communicates for example, whether a gesture of reorder (moving) or deleting(swiping),
 * has been done by the user, in this case de view will execute the appropriate action over the
 * collection of data it shows, and also will communicate to the presenter the UI changes.
 */
public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);

    boolean isHeader(int position);
}
