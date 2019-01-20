package com.example.lambda;

/**
 * Created by sam on 2019/1/20.
 */
@FunctionalInterface
public interface FunctionWolf<T> {
    T get(String name);
}
