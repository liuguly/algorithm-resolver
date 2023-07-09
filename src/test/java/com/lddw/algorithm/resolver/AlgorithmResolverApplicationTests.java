package com.lddw.algorithm.resolver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.PriorityQueue;

class AlgorithmResolverApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


    }


    @Test
    void test1(){
        String s = "angaram";
        int[] table = new int[26];
        for(int i=0;i<s.length();i++){
            int result = s.charAt(i) - 'a';
            table[result]++;
            System.out.print(result + ",");
        }

        System.out.println();
        for(int i=0;i<table.length;i++){
            System.out.print(table[i] +",");
        }

        System.out.println();

        int a= 'a';
        int b = 'b';
        int c = 'c';
        int d = 'd';
        System.out.println("a=" + a);
        System.out.println("b=" +b);
        System.out.println("c=" +c);
        System.out.println("d=" +d);

        System.out.println('c' - 'a');
    }

    boolean angaram(String s, String t){
        if(s.length() !=t.length()){
            return false;
        }
        int[] table = new int[26];
        for(int i=0;i<s.length();i++){
            table[s.charAt(i) - 'a']++;
        }
        for(int j=0;j<t.length();j++){
            table[t.charAt(j) - 'a']--;
            if(table[t.charAt(j) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }



}
