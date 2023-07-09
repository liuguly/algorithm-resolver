package com.lddw.algorithm.resolver.stack;

public class HnTowerUserStack {


    public int hanoiProblem1(int num, String left, String mid, String right){
        if(num < 1){
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public int process(int num, String left, String mid, String right,String from, String to){
        if(num == 1){
            if(from.equals(mid) || to.equals(mid)){
                System.out.println("Move 1 from "+ from + " to "+to);
                return 1;
            }else {
                System.out.println("Move 1 from "+ from + " to "+mid);
                System.out.println("Move 1 from "+mid+ " to "+to);
                return 2;
            }
        }

        if(from.equals(mid) || to.equals(mid)){
            String another = (from.equals(left) || to.equals(left)) ? right: left;

        }

        return 0;

    }


}
