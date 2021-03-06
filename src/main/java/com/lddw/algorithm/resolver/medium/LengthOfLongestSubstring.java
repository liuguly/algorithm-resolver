package com.lddw.algorithm.resolver.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 示例 1: 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2: 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3: 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author liuxin
 */
public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 
     * 以(a)bcabcbb开始的最长字符串为 (abc)abcbb 
     * 以a(b)cabcbb开始的最长字符串为 a(bca)bcbb
     * 以ab(c)abcbb开始的最长字符串为 ab(cab)cbb 
     * 以abc(a)bcbb开始的最长字符串为 abc(abc)bb
     * 以abca(b)cbb开始的最长字符串为 abca(bc)bb 
     * 以abcab(c)bb开始的最长字符串为 abcab(cb)b
     * 以abcabc(b)b开始的最长字符串为 abcabc(b)b 
     * 以abcabcb(b)开始的最长字符串为 abcabcb(b)
     * 
     * 使用滑动窗口来解决这个问题： 1：左指针遍历字符串，每遍历一个，把右指针向右移动，直到出现重复的字符，需要一个数据结构来存储用hashset ()
     * 
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param s 给定字符串
     * @return 结果
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rightKey = -1, len = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rightKey + 1 < n && !set.contains(s.charAt(rightKey + 1))) {
                // 不断的移动右指针
                set.add(s.charAt(rightKey + 1));
                ++rightKey;
            }
            // 第i到rk个字符是一个极长的无重复字符
            len = Math.max(len, rightKey - i + 1);
        }
        return len;
    }

    public static int getMaxSubStrLen(String str) {
        Set<Character> set = new HashSet<>();
        //字符串长度， 右指针初始位置-1表示还没开始移动，结果初始化为0
        int strLength = str.length(), rightKey = -1, result = 0;
        //遍历字符串左指针初始位置0
        for (int leftKey = 0; leftKey < strLength; leftKey++) {
            if (leftKey != 0) {
                //左指针向右移动一格，集合移除一个字符
                set.remove(str.charAt(leftKey - 1));
            }
            //右指针向右移动，直到遇见重复字符跳出循环。
            while (rightKey + 1 < strLength && !set.contains(str.charAt(rightKey + 1))) {
                set.add(str.charAt(rightKey + 1));
                ++rightKey;
            }
            //每循环完一次右指针取最大值，循环完即可获取最终最大值
            result = Math.max(result, rightKey - leftKey + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int result = getMaxSubStrLen("pwwkew");
        System.out.println(result);
    }

}