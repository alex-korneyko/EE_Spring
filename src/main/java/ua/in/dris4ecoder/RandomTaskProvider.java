package ua.in.dris4ecoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Alex Korneyko on 04.07.2016 11:33.
 */
public class RandomTaskProvider implements TaskProvider<ArrayList<Integer>> {

    private List<Task<ArrayList<Integer>>> tasks = new ArrayList<>();

    private int initSize = 0;

    public void init(){
        IntStream.range(0, initSize).forEach(i -> tasks.add(new SimpleTask<>(ArrayList.class)));
    }

    @Override
    public List<Task<ArrayList<Integer>>> getAllTasks() {
        return tasks;
    }

    public void setInitSize(int initSize) {
        this.initSize = initSize;
    }
}
