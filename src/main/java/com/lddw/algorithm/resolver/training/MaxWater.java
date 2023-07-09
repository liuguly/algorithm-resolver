package com.lddw.algorithm.resolver.training;

public class MaxWater {

    public int maxArea(int[] height){
        int maxArea = 0;
        for(int i=0;i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                maxArea = Math.max(maxArea,Math.min(height[i],height[j]) * (j-i));
            }
        }
        return maxArea;
    }

}
