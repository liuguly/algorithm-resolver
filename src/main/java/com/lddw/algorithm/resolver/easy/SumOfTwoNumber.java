package com.lddw.algorithm.resolver.easy;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;

import java.util.Map;

/**
 * <p>
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author LiuXin
 * @date 2019/12/5 10:13
 * @since 1.0
 **/
public class SumOfTwoNumber {

    /**
     * 两次循环时间复杂度o(n²)
     *
     * @param nums   数组
     * @param target 目标值
     * @return 索引
     */
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 关键的一点转变，把两数之和，看成target-num[i]，也即找到nums[j]的位置即可
     * 换句话说：转变为target-nums[i]的值是否存在于数组中，那么就可使用hashMap来解决
     * 注意：这里的map的key存放的是数组值，value存放的是索引，主要为了方便根据值获取索引
     *
     * @param nums   数组
     * @param target 目标值
     * @return 索引数组
     */
    private static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> hash = MapUtil.newHashMap(10);
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (hash.containsKey(key)) {
                return new int[]{hash.get(key), i};
            }
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 9, 10};
        System.out.println(ArrayUtil.toString(twoSum(nums, 10)));
        System.out.println(ArrayUtil.toString(twoSumHash(nums, 10)));
    }
}
