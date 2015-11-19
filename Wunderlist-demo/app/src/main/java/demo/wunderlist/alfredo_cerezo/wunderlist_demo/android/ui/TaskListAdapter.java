package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui;

import android.sax.ElementListener;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.R;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by jachu on 18/11/15.
 * <p/>
 * This class works as an adapter to the list and is the model of the MVP pattern,
 * note that the model in MVP might contain UI element specific properties
 */
public class TaskListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;
    private static final int POSITION_HEADER = 0;

    private ArrayList<Task> mTasks;
    private HeaderListener mHeaderListener;
    private ListElementListener mElementListener;


    public TaskListAdapter(List<Task> tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("tasks cannot be null");
        }
        mTasks = new ArrayList<>();
        mTasks.addAll(tasks);
    }


    public interface HeaderListener {
        void onTaskAddingTouch();

        void onAddTaskTouch(String taskText);
    }

    public interface ListElementListener {
        void onCheckTask(int taskPosition);

        void onUnCheckTask(int taskPosition);
    }

    public void setHeaderListener(HeaderListener listener) {
        if (listener != null) {
            mHeaderListener = listener;
        } else {
            throw new IllegalArgumentException("Header listener can't be null");
        }
    }

    public void setElementListener(ListElementListener listener) {
        if (listener != null) {
            mElementListener = listener;
        } else {
            throw new IllegalArgumentException("Element listener can't be null");
        }
    }

    public Task getTask(int position) {
        return mTasks.get(position - 1); // header
    }

    public void addTask(Task task) {
        mTasks.add(0, task);
        notifyItemInserted(1); //header
    }

    public void removeTask(int taskPosition) {
        mTasks.remove(taskPosition - 1); //header
        notifyItemRemoved(taskPosition);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view;
        switch (viewType) {
            case TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_element, parent, false);
                return new TaskViewHolder(view, mElementListener);

            case TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_element_header, parent, false);
                return new TaskViewHolderHeader(view, mHeaderListener);
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (!isPositionHeader(position)) {
            TaskViewHolder holder = (TaskViewHolder) viewHolder;
            holder.bindTask(this.mTasks.get(position - 1)); // header
        }
    }

    public int getBasicItemCount() {
        return mTasks == null ? 0 : mTasks.size();
    }

    @Override
    public int getItemCount() {
        return getBasicItemCount() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == POSITION_HEADER;
    }

    /**
     * Class to store references to each view of each element of the list,
     * works as the view of the MVP pattern, it sends to the presenter each time
     * the user interacts with the view through the appropriate interface (ListElementListener),
     */
    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        private final TextView taskContent;
        private final CheckBox checkBox;

        public TaskViewHolder(View itemView, final ListElementListener listener) {
            super(itemView);
            taskContent = (TextView) itemView.findViewById(R.id.task_content);
            checkBox = (CheckBox) itemView.findViewById(R.id.task_check_completed);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        if (checkBox.isChecked()) {
                            listener.onCheckTask(getAdapterPosition());
                        } else {
                            listener.onUnCheckTask(getAdapterPosition());
                        }
                    }
                }
            });

        }

        public void bindTask(Task task) {
            taskContent.setText(task.getContent());
            checkBox.setChecked(task.isCompleted());
        }
    }

    /**
     * Class to store references to the header of the list, view in charge of the creation of new tasks,
     * works as the view of the MVP pattern, it sends to the presenter each time
     * the user interacts with the view through the appropriate interface (ListElementListener)
     */
    public static class TaskViewHolderHeader extends RecyclerView.ViewHolder {

        private final EditText taskEditable;
        private final ImageButton addButton;

        public TaskViewHolderHeader(View itemView, final HeaderListener listener) {
            super(itemView);
            taskEditable = (EditText) itemView.findViewById(R.id.header_add_task_text);
            taskEditable.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (listener != null) {
                        listener.onTaskAddingTouch();
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            addButton = (ImageButton) itemView.findViewById(R.id.header_add_text_button);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String taskText = taskEditable.getText().toString();
                    if (!isEmpty(taskText)) {
                        if (listener != null) {
                            listener.onAddTaskTouch(taskText);
                        }
                        resetEditText();
                    }
                }
            });
        }

        private void resetEditText() {
            taskEditable.getText().clear();
        }

        private static boolean isEmpty(String editText) {
            return TextUtils.isEmpty(editText);
        }
    }
}

