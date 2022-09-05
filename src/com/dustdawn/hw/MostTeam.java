package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最多团队(100分)(排序+左右指针)
 * 题目描述：
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为N，每个团队可以由1人或2人组成，
 * 且1个人只能参加1个团队， 请计算出最多可以派出多少支符合要求的团队？
 * 输入描述:
 * 5
 * 3 1 5 7 9
 * 8
 * 第一行数组代表总人数，范围[1,500000]
 * 第二行数组代表每个人的能力，每个元素的取值范围[1, 500000]，数组的大小范围[1,500000]
 * 第三行数值为团队要求的最低能力值，范围[1, 500000]
 * 输出描述：
 * 3
 * 最多可以派出的团队数量
 *
 * @author dustdawn
 * @date 2022/9/5 14:49
 */
public class MostTeam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        // 对数组进行排序
        Arrays.sort(nums);
        int value = in.nextInt();
        int count = 0;
        // 先统计大于等于value的数值个数
        for (int num : nums) {
            if (num >= value) {
                count++;
            }
        }
        // 再统计剩余部分和大于等于value的数量
        int left = 0, right = n - 1 - count;
        while (left < right) {
            if (nums[left] + nums[right] >= value) {
                count++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        System.out.println(count);
        /**
         * 示例 1：
         *
         * 输入
         * 5
         * 3 1 5 7 9
         * 8
         * 输出
         * 3
         * 说明
         * 3,5组成一队，1,7组成一队，9自己一个队，故输出3
         *
         * 示例 2：
         *
         * 输入
         * 7
         * 3 1 5 7 9 2 6
         * 8
         * 输出
         * 4
         * 说明
         * 1、7组成一队 3、5一队 2、6一队 9自己一队 输出4
         *
         * 示例 3：
         *
         * 输入
         * 3
         * 1 1 9
         * 8
         * 输出
         * 1
         * 说明
         * 1、9组成一队 或者9自己一队 输出1
         */
    }
}
