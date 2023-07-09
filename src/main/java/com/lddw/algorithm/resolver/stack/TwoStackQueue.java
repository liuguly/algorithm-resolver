package com.lddw.algorithm.resolver.stack;

import java.util.Stack;

public class TwoStackQueue {

    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue(){
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    private void pushToPop(){
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    public int poll(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.pop();
    }


    public int peek(){
        if(stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        pushToPop();
        return stackPop.peek();
    }


}
