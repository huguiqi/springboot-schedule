package com.example.lambda;

import com.example.WolfStack;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sam on 2019/1/20.
 */
public class LambdaExpTest {

    @Test
    public void testForThread(){

        // 以前的写法
//    Thread tr = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("hello.....");
//        }
//    });
//    tr.start();
  // 现在的写法
        Thread tr = new Thread(()-> System.out.println("hello....."));
        tr.start();
    }

    @Test
    public void testForList(){
    List<String> list = Arrays.asList(new String[] {"b","d","a"});
// java1.8之前的写法
//    Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

// 2. Comparator提供了自然排序的实现
//        Collections.sort(list, Comparator.naturalOrder());

        // 3. lambda 写法
        Collections.sort(list,(o1,o2)->o1.compareTo(o2));
        System.out.println(list);
    }

    @Test
    public void testForLowListStr(){
        List<String> list = Arrays.asList(new String[] {"Wo","Shi","NI","BAba"});

//        List<String> lowList = list.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
        List<String> lowList = list.stream().map(String::toLowerCase).collect(Collectors.toList());

        System.out.println(lowList);
    }


    @Test
    public void testForPrefixStr(){
        List<String> list = Arrays.asList(new String[] {"Wo","Shi","NI","BAba"});
        String preStr = "SB";

        List<String> lowList = list.stream().map(name -> preStr + name.toLowerCase()).collect(Collectors.toList());

        System.out.println(lowList);

    }

    @Test
    public void testDistinct(){
        List<Integer> list = Arrays.asList(new Integer[]{3,4,5,1,6,3,1,2,5});
        List<Integer> distincts = list.stream().distinct().collect(Collectors.toList());
        Collections.sort(distincts, Comparator.naturalOrder());
        distincts.forEach(System.out::println);
    }

    @Test
    public void testLambdaFunctionIntefarce(){
        //函数式接口满足条件
        //1. 只允许声明一个抽象方法
        //2. @FunctionalInterface注解只用来告诉编译器，这是一个函数式接口，如果不加，也可以当做函数式接口使用

        Double generate = WolfStack.generate(new FunctionWolf<Double>() {

            @Override
            public Double get(String name) {
                if ("name1".equalsIgnoreCase(name))
                    return new Double(100);
                else
                    return new Double(1.1);
            }
        });

        System.out.println(generate);

        Double generate1 = WolfStack.generate((name) -> new Double(100.11));

        System.out.println(generate1);


    }
}
