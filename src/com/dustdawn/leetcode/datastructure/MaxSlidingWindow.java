package com.dustdawn.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 239. 滑动窗口最大值(单调栈)
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。返回 滑动窗口中的最大值 。
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * @author dustdawn
 * @date 2022/5/21 14:51
 */
public class MaxSlidingWindow {
    /**
     * 单调队列解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        /*
        MonotonicQueue window = new MonotonicQueue();
        // 方便按照索引取元素
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满 k - 1 个元素
                window.push(nums[i]);
            } else {
                // 窗口开始向前滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口的最大元素记录入结果
                res.add(window.max());
                // 移除旧数字，即窗口最左边的数字（不是在window中最左，window中为压缩后的单调递减）：在nums[i]前(k - 1)位的数字
                // pop为移除单调队列中最大的数字，如nums[i - k + 1]不为最大数字，不移除也不影响单次窗口的最大值
                window.pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }*/
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
            } else {
                while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
                res.add(queue.getFirst());
                // 首位元素
                if (queue.getFirst() == nums[i - k + 1]) {
                    queue.pollFirst();
                }
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
         * 输出：[3,3,5,5,6,7]
         * 解释：
         * 滑动窗口的位置                最大值
         * ---------------               -----
         * [1  3  -1] -3  5  3  6  7       3
         *  1 [3  -1  -3] 5  3  6  7       3
         *  1  3 [-1  -3  5] 3  6  7       5
         *  1  3  -1 [-3  5  3] 6  7       5
         *  1  3  -1  -3 [5  3  6] 7       6
         *  1  3  -1  -3  5 [3  6  7]      7
         * 示例 2：
         *
         * 输入：nums = [1], k = 1
         * 输出：[1]
         */
        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        System.out.println(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3));
        System.out.println(maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4));
    }
}
