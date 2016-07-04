package ua.in.dris4ecoder;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

public abstract class ExecutorFactory {

    public abstract Executor<ArrayList<Integer>> getIntegerExecutor();
}
