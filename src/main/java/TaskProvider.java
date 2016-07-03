import java.util.List;

/**
 * Created by Alex Korneyko on 03.07.2016 18:52.
 */
public interface TaskProvider<T> {

    List<Task<T>> getAllTasks();
}
