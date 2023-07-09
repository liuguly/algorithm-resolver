package com.lddw.algorithm.resolver.lambda;

import lombok.Data;

import java.util.*;
import java.util.function.Supplier;

public class LambdaTest {

    public void createLambda(){
        List<String> str = Arrays.asList("a","b","c");
        str.sort(String::compareToIgnoreCase);

        Supplier<Apple> c = Apple::new;
        Apple obj = c.get();

        List<Apple> inventory = new ArrayList<>();
        inventory.sort(Comparator.comparing(Apple::getName).reversed().thenComparing(Apple::getDesc));

        Integer[] ints = {1,2,11,2,4,5,6,7,8};
        Optional<Integer> optional =Arrays.stream(ints).reduce(Integer::max);
        optional.ifPresent(System.out::println);
    }


    @Data
    public class Apple{
        private String name;
        private String desc;
    }

}
