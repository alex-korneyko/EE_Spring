package ua.in.dris4ecoder;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

public class Main {

    private TaskProvider<ArrayList<Integer>> taskProvider;
    private ExecutorFactory executorFactory;

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Main mainClass = applicationContext.getBean("main", Main.class);
        mainClass.execute();
        mainClass.execute();

    }

    public void execute() {

        Executor<ArrayList<Integer>> executor = executorFactory.getIntegerExecutor();

        taskProvider.getAllTasks().forEach(executor::addTask);
        executor.execute();

        System.out.println("\nValid results: " + executor.getValidResults().size());
        executor.getValidResults().forEach(System.out::println);
        System.out.println("\nInvalid results: " + executor.getInvalidResults().size());
        executor.getInvalidResults().forEach(System.out::println);
    }

    public void setTaskProvider(TaskProvider<ArrayList<Integer>> taskProvider) {
        this.taskProvider = taskProvider;
    }

    public void setExecutorFactory(ExecutorFactory executorFactory) {
        this.executorFactory = executorFactory;
    }
}
