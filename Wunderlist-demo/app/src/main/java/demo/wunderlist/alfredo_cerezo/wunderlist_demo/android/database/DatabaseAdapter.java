package demo.wunderlist.alfredo_cerezo.wunderlist_demo.android.database;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.LinkedList;
import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;

/**
 * Created by alfredocerezoluna on 16/11/15.
 */
public class DatabaseAdapter {

    public DatabaseAdapter() {

    }

    public void createTask(Task task) {
        TaskModel taskModel = getModelFromTask(task);
        taskModel.insert();
    }

    public List<Task> getAllTask() {
        List<TaskModel> tasksModel = new Select().all().from(TaskModel.class).queryList();
        return adapt(tasksModel);
    }

    private List<Task> adapt(List<TaskModel> taskModels) {
        List<Task> tasks = new LinkedList<>();

        for (TaskModel task : taskModels) {
            Task concreteTask = getTaskFromModel(task);
            tasks.add(concreteTask);
        }

        return tasks;
    }

    private TaskModel getModelFromTask(Task task) {
        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(task.getTaskId());
        taskModel.setCompleted(task.isCompleted());
        taskModel.setOrder(task.getOrder());
        taskModel.setContent(task.getContent());

        return taskModel;

    }

    private Task getTaskFromModel(TaskModel model) {
        Task task = new Task();
        task.setTaskId(model.getTaskId());
        task.setOrder(model.getOrder());
        task.setContent(model.getContent());
        task.setCompleted(model.isCompleted());

        return task;
    }

}
