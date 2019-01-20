package com.example;


import com.example.lambda.FunctionWolf;

import java.util.Objects;

/**
 * Created by sam on 2019/1/20.
 */
public class WolfStack {

    public static <T> T generate(FunctionWolf<T> s) {
        Objects.requireNonNull(s);
        return s.get("name1");
    }
}
