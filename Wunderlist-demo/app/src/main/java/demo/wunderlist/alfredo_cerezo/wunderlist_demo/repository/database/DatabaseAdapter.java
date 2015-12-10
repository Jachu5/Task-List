package demo.wunderlist.alfredo_cerezo.wunderlist_demo.repository.database;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.LinkedList;
import java.util.List;

import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.Task;
import demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities.TaskFactory;

/**
 * Created by alfredocerezoluna on 16/11/15.
 * <p/>
 * This adapter is the final layer (a concrete implementation ) of the repository gateway, it handles the logic to store the data
 * in a specific repository, in this case a DB managed by DBFlow.
 */
public class DatabaseAdapter {

    public DatabaseAdapter() {

    }

    public void deleteTask(Task task) {
        TaskModel taskModel = getModelFromTask(task);
        taskModel.delete();
    }

    public void updateTask(Task task) {
        TaskModel taskModel = getModelFromTask(task);
        taskModel.update();
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
        taskModel.setId(task.getId());
        taskModel.setCompleted(task.isCompleted());
        taskModel.setContent(task.getContent());
        taskModel.setPosition(task.getPosition());
        return taskModel;

    }

    private Task getTaskFromModel(TaskModel model) {
        Task task = TaskFactory.createTaskWithId(model.getId(), model.isCompleted(),
                model.getContent(), model.getPosition());

        return task;
    }

}
