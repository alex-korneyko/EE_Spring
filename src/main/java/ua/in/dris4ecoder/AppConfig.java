package ua.in.dris4ecoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class AppConfig {

    @Bean
    public Main main(TaskProvider<ArrayList<Integer>> randomTaskProvider, ExecutorFactory executorFactory) {
        Main main = new Main();
        main.setTaskProvider(randomTaskProvider);
        main.setExecutorFactory(executorFactory);
        return main;
    }

    @Bean
    public TaskProvider<ArrayList<Integer>> randomTaskProvider() {

        RandomTaskProvider randomTaskProvider = new RandomTaskProvider();
//        randomTaskProvider.setInitSize(10000);
        randomTaskProvider.init(10000);
        return randomTaskProvider;
    }

    @Bean
    @Scope("prototype")
    public MainExecutor<ArrayList<Integer>> mainExecutor() {
        return new MainExecutor<>();
    }

    @Bean
    public ExecutorFactory executorFactory() {
        return new ExecutorFactory() {
            @Override
            public Executor<ArrayList<Integer>> getIntegerExecutor() {
                return mainExecutor();
            }
        };
    }
}
