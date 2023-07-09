package com.lddw.algorithm.resolver.training;


import java.io.File;
import java.util.*;

/**
 * 深度优先遍历 depth first search
 */
public class Dfs {

    private Set<TreeNode> visited = new HashSet<>(15);

    public void dfs(TreeNode node){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        dfs(node.left);
        dfs(node.right);
    }


    public void dfsMutilTreeNode(TreeNode node){
        visited.add(node);

        //xxxxxxxxxxxxxx

    }


//    public void recur(int level, int param){
//
//        if(level > MAX_LEVEL){
//            return ;
//        }
//
//        process(param);
//
//        recur(level+1, newParam);
//    }

    public int fibonacci(int n){
        return n <=1 ?n : fibonacci(n-1) + fibonacci(n -2 );
    }

    public int fibonacci(int n, int[] memo){
        if(n <=1){
            return n;
        }
        if(memo[n] == 0){
            memo[n] = fibonacci(n-1,memo) + fibonacci(n-2, memo);
        }
        return memo[n];
    }


    public static void main(String[] args) {
        File  file = new File("F:\\所有音乐");
        File[] files = file.listFiles();
        TreeSet<String> treeSet = new TreeSet<>();
        for(int i = 0; i< Objects.requireNonNull(files).length; i++){
            treeSet.add(files[i].getName());
        }
        treeSet.forEach(System.out::println);
    }

}
