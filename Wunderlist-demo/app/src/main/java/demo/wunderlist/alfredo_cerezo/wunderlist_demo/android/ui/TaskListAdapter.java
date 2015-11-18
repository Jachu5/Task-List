package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.R;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by jachu on 18/11/15.
 */
public class TaskListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Task> mTasks;
    //added view types
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;


    public TaskListAdapter(List<Task> tasks) {
        if (tasks == null) {
            throw new IllegalArgumentException("tasks cannot be null");
        }
        mTasks = tasks;

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
                return new TaskViewHolderHeader(view);
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
        return position == 0;
    }

    public static class TaskViewHolder
            extends RecyclerView.ViewHolder {

        private final TextView txtTitulo;

        public TaskViewHolder(View itemView, TextView itemTextView) {
            super(itemView);
            txtTitulo = itemTextView;

        }

        public static TaskViewHolder newInstance(View parent) {
            TextView txtTitulo = (TextView) parent.findViewById(R.id.task_content);
            return new TaskViewHolder(parent, txtTitulo);
        }

        public void bindTask(Task task) {
            txtTitulo.setText(task.getContent());
        }
    }

    public class TaskViewHolderHeader extends RecyclerView.ViewHolder {
        public TaskViewHolderHeader(View itemView) {
            super(itemView);
        }
    }

}
