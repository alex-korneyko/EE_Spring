package ua.in.dris4ecoder;

import java.util.ArrayList;

/**
 * Created by Alex Korneyko on 03.07.2016 20:11.
 */
public abstract class ExecutorFactory {

    public abstract Executor<ArrayList<Integer>> getIntegerExecutor();
}
