package com.lddw.algorithm.resolver;

import org.junit.jupiter.api.Test;

public class RandomAlg {


    /**
     * 等概率1-5
     */
    @Test
    public void testRand() {
        int count = 0;
        int length = 10000;
        for(int i=0; i < length; i++){
            if(f2() == 0){
                count++;
            }
        }
        System.out.println((double) count/ (double) length);
    }

    public int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 随机机制，只能用f1
     *
     * @return 0 1等概率返回
     */
    public int f2() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * 等到000 ~ 111等概率
     * @return
     */
    public int f3(){
        return f2() << 2 + f2() << 1 + f2();
    }


    public int x(){
        return Math.random() < 0.84 ? 0:1;
    }

    public int y(){
        int ans = 0;
        do{
            ans = x();
        }while (ans == x());
        return ans;
    }



}
