package com.lddw.algorithm.resolver.stack;

import java.util.Stack;

public class GetMinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;


    public GetMinStack(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("your statck is empty");
        }
        int value = this.stackData.pop();
        if(value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }

}
