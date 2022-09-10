package com.dustdawn.hw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 污染水域(200)(多源BFS+队列)
 * 题目描述
 * 输入一行字符串，字符串可转换为N*N的数组，数组可认为是一个水域，判断多少天后，水域被全部污染。
 * 数组中只有0和1，0表示纯净，1表示污染，每天只可污染上下左右的水域，如果开始全部被污染，或永远无法污染，则返回-1。
 *
 * @author dustdawn
 * @date 2022/9/4 15:18
 */
public class W_PolluteWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int n = (int) Math.sqrt(split.length);
        int[][] nums = new int[n][n];
        // 图的多源BFS
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        // 污染源入队列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(split[i * n + j]);
                if (nums[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == n * n) {
            System.out.println(-1);
            return;
        }
        int[] poll = null;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            // 四个方向BFS
            for (int i = 0; i < 4; i++) {
                int newX = poll[0] + dx[i];
                int newY = poll[1] + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= n || nums[newX][newY] != 0) {
                    continue;
                }
                nums[newX][newY] = nums[poll[0]][poll[1]] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
        System.out.println(nums[poll[0]][poll[1]] - 1);
        /**
         * 示例
         * 输入
         * 1,0,1,0,0,0,1,0,1
         * 输出
         * 2
         * 解释：
         * 转化为数组为：
         * 1 0 1
         * 0 0 0
         * 1 0 1
         * 第一天后水域变为
         * 1 1 1
         * 1 0 1
         * 1 1 1
         * 第二天全部被污染
         * 输入
         * 0,0,0,0
         * 输出
         * -1
         * 思路分析
         * 这道题是典型的图的多源BFS问题，可以参考【Leetcode】图的多源BFS详解加强对图的多源BFS方法的学习。
         * 这道题跟leetcode：1162. 地图分析意思是一样的，都是从多个源点开始，向四周扩展，问多少次能扩展完。
         * 解题流程：
         * 先把所有的污染源都入队
         * 然后从各个污染源同时开始一圈一圈的向净水扩散，
         * 那么最后扩散到的净水就是花费的天数！
         * 注：这里有一个小细节就是，可以直接修改原数组，扩散到了就在原数组上加1，最后统计数组中最大值-1即可。
         * 这里我同时把队列输出数组定义到循环外面，这样就可以直接输出最后一次扩散的值减1即可。
         */
    }

}
