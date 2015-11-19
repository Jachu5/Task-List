package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.R;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by jachu on 18/11/15.
 */
public class TaskListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LinkedList<Task> mTasks;

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;

    public TaskListAdapter(List<Task> tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("tasks cannot be null");
        }
        mTasks = new LinkedList<>();
        mTasks.addAll(tasks);
    }

    public interface onClickAddListener {
        void setTaskText(String taskText);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view;
        switch (viewType) {
            case TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_element, parent, false);
                return TaskViewHolder.newInstance(view);

            case TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_element_header, parent, false);
                return TaskViewHolderHeader.newInstance(view);
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (!isPositionHeader(position)) {
            TaskViewHolder holder = (TaskViewHolder) viewHolder;
            holder.bindTask(this.mTasks.get(position - 1)); // header
        } else {
            TaskViewHolderHeader holder = (TaskViewHolderHeader) viewHolder;
            onClickAddListener listener = new onClickAddListener() {

                @Override
                public void setTaskText(String taskText) {
                    Task task = new Task();
                    task.setContent(taskText);
                    mTasks.addFirst(task);
                    TaskListAdapter.this.notifyItemInserted(1);
                }
            };
            holder.setDataUpdateListener(listener);

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
        return position == 0;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        private final TextView taskContent;

        public TaskViewHolder(View itemView, TextView itemTextView) {
            super(itemView);
            taskContent = itemTextView;

        }

        public static TaskViewHolder newInstance(View parent) {
            TextView taskContent = (TextView) parent.findViewById(R.id.task_content);
            return new TaskViewHolder(parent, taskContent);
        }

        public void bindTask(Task task) {
            taskContent.setText(task.getContent());
        }
    }

    public static class TaskViewHolderHeader extends RecyclerView.ViewHolder {

        private final EditText taskEditable;
        private final ImageButton addButton;
        private onClickAddListener listener;

        public TaskViewHolderHeader(View itemView, EditText itemEditTextView, ImageButton button) {
            super(itemView);
            taskEditable = itemEditTextView;
            addButton = button;
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String taskText = taskEditable.getText().toString();
                    if (!isEmpty(taskText)) {
                        listener.setTaskText(taskText);
                    }
                }
            });
        }


        private static boolean isEmpty(String editText) {
            return TextUtils.isEmpty(editText);
        }

        public static TaskViewHolderHeader newInstance(View parent) {
            EditText taskEditable = (EditText) parent.findViewById(R.id.header_add_task_text);
            ImageButton addButton = (ImageButton) parent.findViewById(R.id.header_add_text_button);

            return new TaskViewHolderHeader(parent, taskEditable, addButton);
        }

        public void setDataUpdateListener(onClickAddListener listener) {
            this.listener = listener;
        }


    }
}

