package ua.in.dris4ecoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex Korneyko on 03.07.2016 18:54.
 */
public class IntegerTaskProvider implements TaskProvider<ArrayList<Integer>> {

    private List<Task<ArrayList<Integer>>> tasks = new ArrayList<>();

    public void init() {

        tasks.add(new SimpleTask<>(ArrayList.class, new ArrayList<>(Arrays.asList(8, 1, 2, 3, 5))));
        tasks.add(new SimpleTask<>(ArrayList.class, new ArrayList<>(Arrays.asList(8, 1, 2, 3, 5, 123, 68, 426, 78, 4456))));
        tasks.add(new SimpleTask<>(ArrayList.class, new ArrayList<>(Arrays.asList(15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0))));
        tasks.add(new SimpleTask<>(ArrayList.class, new ArrayList<>(Arrays.asList(6, 1, 2, 4, 3, 5))));
        tasks.add(new SimpleTask<>(ArrayList.class, new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3))));
    }

    @Override
    public List<Task<ArrayList<Integer>>> getAllTasks() {
        return tasks;
    }
}
