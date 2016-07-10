package ua.in.dris4ecoder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Korneyko on 09.07.2016 21:16.
 */
@Aspect
public class LogAspect {

    @Around("execution( * Executor.addTask(Task)) && args(task)")
    public void onExecute(ProceedingJoinPoint pjp, Task task) throws Throwable {

        ((Executor<ArrayList<Integer>>) pjp.getTarget()).addTask(task, new SimpleValidator<>());

    }

}
