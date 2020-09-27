package com.lddw.algorithm.resolver.harder;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为
 * O(log(m + n))。 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1: nums1 = [1, 3] nums2 = [2] 则中位数是 2.0 示例 2: nums1 = [1,2,4, 6, 9] nums2
 * = [3，6，9] 则中位数是 5.0 示例 3: nums1 = [1, 2] nums2 = [3, 4,5,6] 则中位数是 (3 + 4)/2 =
 * 3.5
 * 
 * 
 * 方法一：二分查找
 * 
 * 给定两个有序数组，要求找到两个有序数组的中位数，最直观的思路有以下两种：
 * 
 * 1:使用归并的方式，合并两个有序数组，得到一个大的有序数组。大的有序数组的中间位置的元素，即为中位数。
 * 2:不需要合并两个有序数组，只要找到中位数的位置即可。由于两个数组的长度已知，因此中位数对应的两个数组的下标之和也是已知的。维护两个指针，初始时分别指向两个数组的下标
 * 0的位置，每次将指向较小值的指针后移一位（如果一个指针已经到达数组末尾，则只需要移动另一个数组的指针），直到到达中位数的位置。
 * 
 * 
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author liuxin
 */
public class _4_FindMedianSortedArrays {

    public static double findMedio(int[] nums1, int[] nums2) {
        // int[] nums1 = { 3, 4, 7, 9,11,12};
        // int[] nums2 = { 2, 5, 7, 10, 14 };
        // (m+n)/2 (m+n+2)/2
        int n1Key = 0;
        int n2Key = 0;
        int c = (nums1.length + nums2.length) % 2;
        int index = 0;
        if (c == 1) {
            //奇数
            int midIndex = (nums1.length + nums2.length) / 2 ;
            while (n1Key < nums1.length || n2Key < nums2.length) {
                index++;
                int v1 = nums1[n1Key];
                int v2 = nums2[n2Key];
                if (v1 < v2) {
                    if (midIndex == index) {
                        return nums1[n1Key];
                    }
                    n1Key++;
                } else {
                    if (midIndex == index) {
                        return nums2[n2Key];
                    }
                    n2Key++;
                }
            }
        } else {
            //奇数 9/2 = 4   中间位置是4    123456789
            int midIndex = (nums1.length + nums2.length ) / 2 ;
            //偶数 8/2 =4   中间位置是3和4    12345678
            int mideIndex1 = (nums1.length + nums2.length) / 2;
            int midIndex2 = (nums1.length + nums2.length - 1) / 2;


        }
        return 0;
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // 使nums1成为较短数组,不仅可以提高检索速度,同时可以避免一些边界问题
        if (nums1.length > nums2.length) {
          int[] temp = nums1;
          nums1 = nums2;
          nums2 = temp;
        }
    
        int len1 = nums1.length;
        int len2 = nums2.length;
        int leftLen = (len1 + len2 + 1) / 2; //两数组合并&排序后,左半边的长度
        
        // 对数组1进行二分检索
        int start = 0;
        int end = len1;
        while (start <= end) {
          // 两个数组的被测数A,B的位置(从1开始计算)
          // count1 = 2 表示 num1 数组的第2个数字
          // 比index大1
          int count1 = start + ((end - start) / 2);
          int count2 = leftLen - count1;
          
          if (count1 > 0 && nums1[count1 - 1] > nums2[count2]) {
            // A比B的next还要大
            end = count1 - 1;
          } else if (count1 < len1 && nums2[count2 - 1] > nums1[count1]) {
            // B比A的next还要大
            start = count1 + 1;
          } else {
            // 获取中位数
            int result =  (count1 == 0)? nums2[count2 - 1]: // 当num1数组的数都在总数组右边
                          (count2 == 0)? nums1[count1 - 1]: // 当num2数组的数都在总数组右边
                          Math.max(nums1[count1 - 1], nums2[count2 - 1]); // 比较A,B
            if (isOdd(len1 + len2)) {
              return result;
            }
    
            // 处理偶数个数的情况
            int nextValue = (count1 == len1) ? nums2[count2]:
                            (count2 == len2) ? nums1[count1]:
                            Math.min(nums1[count1], nums2[count2]);
            return (result + nextValue) / 2.0;
          }
        }
    
        return Integer.MIN_VALUE; // 绝对到不了这里
      }
    
      // 奇数返回true,偶数返回false
      private static boolean isOdd(int x) {
        return (x & 1) == 1;
      }

    public static void main(String[] args) {
        int[] nums1 = { 3, 4, 7, 9 };
        int[] nums2 = { 2, 5, 7, 10 };
        double result = findMedianSortedArrays1(nums1, nums2);
        System.out.println(result);


        int[] nums3 = { 7,11,15,16,20};
        int[] nums4 = { 2, 5, 7, 10, 14, 17 };
        System.out.println("nums3.len=" + nums3.length);
        System.out.println(findMedianSortedArrays1(nums3, nums4));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1))
                    / 2.0;
            return median;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        /*
         * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1]
         * 进行比较 这里的 "/" 表示整除 nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个 nums2
         * 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个 取 pivot = min(pivot1,
         * pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个 这样 pivot
         * 本身最大也只能是第 k-1 小的元素 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k
         * 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组 如果 pivot = pivot2，那么 nums2[0 .. k/2-1]
         * 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组 由于我们 "删除" 了一些元素（这些元素都比第 k
         * 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
