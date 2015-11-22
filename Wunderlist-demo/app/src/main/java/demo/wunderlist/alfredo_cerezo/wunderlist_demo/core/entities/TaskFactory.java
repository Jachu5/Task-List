package demo.wunderlist.alfredo_cerezo.wunderlist_demo.core.entities;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by alfredocerezoluna on 22/11/15.
 */
public class TaskFactory {

    private static final int ID_LENGTH = 10;

    public static Task createTaskWithId(String id, boolean completed, String content, int position) {
        Task task = new Task();
        task.setId(id);
        task.setCompleted(completed);
        task.setContent(content);
        task.setPosition(position);

        return task;

    }

    public static Task createTaskWithNoId(boolean completed, String content, int position) {
        Task task = new Task();
        task.setId(generateUniqueId());
        task.setCompleted(completed);
        task.setContent(content);
        task.setPosition(position);

        return task;

    }

    private static String generateUniqueId() {
        return RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }
}
