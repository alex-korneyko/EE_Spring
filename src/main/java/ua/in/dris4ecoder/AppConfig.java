package ua.in.dris4ecoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;


@Configuration
public class AppConfig {

    @Bean
    public Main main(ExecutorFactory executorFactory, TaskProvider<ArrayList<Integer>> integerTaskProvider){
        Main main = new Main();
        main.setExecutorFactory(executorFactory);
        main.setTaskProvider(integerTaskProvider);
        return main;
    }

    @Bean
    public TaskProvider<ArrayList<Integer>> integerTaskProvider(){
        IntegerTaskProvider integerTaskProvider = new IntegerTaskProvider();
        integerTaskProvider.init();
        return integerTaskProvider;
    }

    @Bean
    @Scope("prototype")
    public MainExecutor<ArrayList<Integer>> mainExecutor(){
        return new MainExecutor<>();
    }

    @Bean
    public ExecutorFactory executorFactory(){
        return new ExecutorFactory() {
            @Override
            public Executor<ArrayList<Integer>> getIntegerExecutor() {
                return mainExecutor();
            }
        };
    }
}
