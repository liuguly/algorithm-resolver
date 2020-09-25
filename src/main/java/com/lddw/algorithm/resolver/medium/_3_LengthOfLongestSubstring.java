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
public class _3_LengthOfLongestSubstring {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 
     * 以(a)bcabcbb\texttt{(a)bcabcbb}(a)bcabcbb 开始的最长字符串为  (abc)abcbb\texttt{(abc)abcbb}(abc)abcbb； 
     * 以a(b)cabcbb\texttt{a(b)cabcbb}a(b)cabcbb 开始的最长字符串为  a(bca)bcbb\texttt{a(bca)bcbb}a(bca)bcbb； 
     * 以ab(c)abcbb\texttt{ab(c)abcbb}ab(c)abcbb 开始的最长字符串为  ab(cab)cbb\texttt{ab(cab)cbb}ab(cab)cbb； 
     * 以abc(a)bcbb\texttt{abc(a)bcbb}abc(a)bcbb 开始的最长字符串为  abc(abc)bb\texttt{abc(abc)bb}abc(abc)bb； 
     * 以abca(b)cbb\texttt{abca(b)cbb}abca(b)cbb 开始的最长字符串为  abca(bc)bb\texttt{abca(bc)bb}abca(bc)bb； 
     * 以abcab(c)bb\texttt{abcab(c)bb}abcab(c)bb 开始的最长字符串为  abcab(cb)b\texttt{abcab(cb)b}abcab(cb)b； 
     * 以abcabc(b)b\texttt{abcabc(b)b}abcabc(b)b 开始的最长字符串为  abcabc(b)b\texttt{abcabc(b)b}abcabc(b)b； 
     * 以abcabcb(b)\texttt{abcabcb(b)}abcabcb(b) 开始的最长字符串为  abcabcb(b)\texttt{abcabcb(b)}abcabcb(b);
     *  
     * 使用滑动窗口来解决这个问题：
     * 
     * 
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * 
     * @param s 给定字符串
     * @return 结果
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                //不断的移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            //第i到rk个字符是一个极长的无重复字符
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("pwwkew");
        String str = "pwdabdcfsfgdd";
        int left = 0;
        int right = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            
        }

        System.out.println(result);
    }

}