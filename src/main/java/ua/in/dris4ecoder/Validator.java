package ua.in.dris4ecoder;

import java.util.List;

public interface Validator<T extends List<Integer>> {

    // Валидирует переданое значение
    boolean isValid(T result, Class<? extends List> classObject) throws IllegalAccessException, InstantiationException;
}
