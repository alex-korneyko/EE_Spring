package ua.in.dris4ecoder;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Alex Korneyko on 03.06.2016.
 */
@Component
public class Main {

    private TaskProvider<ArrayList<Integer>> taskProvider;
    private ObjectFactory<Executor<ArrayList<Integer>>> executorFactory;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main mainClass = applicationContext.getBean("main", Main.class);
        mainClass.execute();
        mainClass.execute();

    }

    public void execute() {

        Executor<ArrayList<Integer>> executor = executorFactory.getObject();

        taskProvider.getAllTasks().forEach(executor::addTask);
        executor.execute();

        System.out.println("\nValid results: " + executor.getValidResults().size());
        executor.getValidResults().forEach(System.out::println);
        System.out.println("\nInvalid results: " + executor.getInvalidResults().size());
        executor.getInvalidResults().forEach(System.out::println);
    }

    @Autowired
    public void setTaskProvider(TaskProvider<ArrayList<Integer>> taskProvider) {
        this.taskProvider = taskProvider;
    }

    @Autowired
    public void setExecutorFactory(ObjectFactory<Executor<ArrayList<Integer>>> executorFactory) {
        this.executorFactory = executorFactory;
    }
}
