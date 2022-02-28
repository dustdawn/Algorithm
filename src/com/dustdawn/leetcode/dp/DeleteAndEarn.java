package com.dustdawn.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 *
 * @author dustdawn
 * @date 2022/2/28 20:41
 */
public class DeleteAndEarn {
    /**
     * I.将条件转换成【198. 打家劫舍】的场景，值为nums[i]和nums[i] - 1、nums[i] + 1的不能同时选
     * 转换成sum[nums[i]]和sum[nums[i] - 1]、sum[nums[i] + 1]不能同时选。
     * 其中sum[nums[i]]表示nums数组中元素值为nums[i]的总和，值即为nums[i]*出现次数
     */
    public static int deleteAndEarn(int[] nums) {
        // sum数组的大小为nums[i]的最大值+1
        int maxValue = 0;
        for (int val : nums) {
            maxValue = Math.max(val, maxValue);
        }
        int[] sum = new int[maxValue + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    /**
     * 相隔元素不能选择条件下求得nums选择元素后的总和
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i < n; i++) {
            temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * II.将数组进行排序，再分成多个子数组，每个子数组之间的元素相差不超过1
     * 每个子数组的值为总和
     * 对每个子数组进行【198. 打家劫舍】操作
     */
    public static int deleteAndEarn2(int[] nums) {
        int n = nums.length;
        // 点数总和
        int ans = 0;
        Arrays.sort(nums);
        // sum.get(i)表示第i个子数组的总和
        List<Integer> sum = new ArrayList<>();
        sum.add(nums[0]);
        // 子数组的个数
        int size = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                // 元素相等，添加进对应子数组，子数组求和
                sum.set(size - 1, sum.get(size - 1) + nums[i]);
            } else if (nums[i] == nums[i - 1] + 1) {
                // 排序后的数组元素前后如果相差1，放入新的子数组
                sum.add(nums[i]);
                // 数组大小增加，新的子数组索引即为size - 1
                size++;
            } else {
                // 当前元素和前一个元素（前一个元素小于当前元素）相差大于1
                // 此时将前面size个子数组进行“相隔不可取最大求值”
                // 累加点数总和，然后清空所有子数组进行后续的子数组划分
                ans += rob(sum);
                sum.clear();
                sum.add(nums[i]);
                size = 1;
            }
        }
        ans += rob(sum);
        return ans;
    }

    public static int rob(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int n = nums.size();
        if (n == 1) {
            return nums.get(0);
        }
        int a = nums.get(0);
        int b = Math.max(nums.get(0), nums.get(1));
        int temp;
        for (int i = 2; i < n; i++) {
            temp = Math.max(a + nums.get(i), b);
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nums = [3,4,2]
         * 输出：6
         * 解释：
         * 删除 4 获得 4 个点数，因此 3 也被删除。
         * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
         * 示例 2：
         *
         * 输入：nums = [2,2,3,3,3,4]
         * 输出：9
         * 解释：
         * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
         * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
         * 总共获得 9 个点数。
         */
    }
}
