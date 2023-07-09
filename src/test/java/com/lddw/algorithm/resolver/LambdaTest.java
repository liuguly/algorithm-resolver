package com.lddw.algorithm.resolver;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaTest {

    @Test
    public void createLambda(){
//        List<String> str = Arrays.asList("a","b","c");
//        str.sort(String::compareToIgnoreCase);
//
//        Supplier<Apple> c = Apple::new;
//        Apple obj = c.get();
//
//        List<Apple> inventory = new ArrayList<>();
//        inventory.sort(Comparator.comparing(Apple::getName).reversed().thenComparing(Apple::getDesc));
//
//        Integer[] ints = {1,2,11,2,4,5,6,7,8};
//        Optional<Integer> optional =Arrays.stream(ints).reduce(Integer::max);
//        optional.ifPresent(System.out::println);

        print(10);

    }

    public void print(int num){
        for(int i=31;i>=0;i--){
            System.out.print((num & (1 << i)) ==0 ? "0":"1");
        }
    }


    @Data
    public class Apple{
        private String name;
        private String desc;
    }


    public long sequentialSum(long n){
        return Stream.iterate(1L, i->i+1).limit(n).reduce(0L,Long::sum);
    }

}
