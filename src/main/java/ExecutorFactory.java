import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 03.07.2016 20:11.
 */
public abstract class ExecutorFactory {

    public abstract Executor<ArrayList<Integer>> getIntegerExecutor();
}
