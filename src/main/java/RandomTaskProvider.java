import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Alex Korneyko on 04.07.2016 11:33.
 */
public class RandomTaskProvider implements TaskProvider<List<Integer>> {

    private List<Task<List<Integer>>> tasks = new ArrayList<>();

    public void init(){
        IntStream.range(0, 10_000).forEach(i -> tasks.add(new SimpleTask<>(ArrayList.class)));
    }


    @Override
    public List<Task<List<Integer>>> getAllTasks() {
        return tasks;
    }
}