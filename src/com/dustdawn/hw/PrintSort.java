package com.dustdawn.hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 打印任务排序(200分)(队列)
 * 题目描述
 * 某个打印机根据打印队列执行打印任务。打印任务分为九个优先级，分别用数字1-9表示，数字越大优先级越高。打印机每次从队列头部取出第一个任务A，
 * 然后检查队列余下任务中有没有比A优先级更高的任务，如果有比A优先级高的任务，则将任务A放到队列尾部，否则就执行任务A的打印。
 * 请编写一个程序，根据输入的打印队列，输出实际的打印顺序。
 * 输入描述
 * 输入一行，为每个任务的优先级，优先级之间用逗号隔开，优先级取值范围是1~9。
 * 输出描述
 * 输出一行，为每个任务的打印顺序，打印顺序从0开始，用逗号隔开
 *
 * @author dustdawn
 * @date 2022/9/5 21:31
 */
public class PrintSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] tasks = in.nextLine().split(",");
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            queue.add(new int[]{Integer.parseInt(tasks[i]), i});
        }
        String[] result = new String[tasks.length];
        int idx = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean hasLarger = false;
            for (int[] t : queue) {
                if (t[0] > cur[0]) {
                    hasLarger = true;
                    break;
                }
            }
            if (hasLarger) {
                queue.add(cur);
            } else {
                result[cur[1]] = String.valueOf(idx++);
            }
        }
        System.out.println(String.join(",", result));
        /**
         * 示例
         * 输入
         * 9,3,5
         * 输出
         * 0,2,1
         * 说明
         * 队列头部任务的优先级为9，最先打印，故序号为0；
         * 接着队列头部任务优先级为3，队列中还有优先级为5的任务，优先级3任务被移到队列尾部；
         * 接着打印优先级为5的任务，故其序号为1；
         * 最后优先级为3的任务的序号为2。
         * 输入
         * 1,2,2
         * 输出
         * 2,0,1
         * 说明
         * 注意2是按顺序。
         *
         * 思路分析
         * 这是一道模拟题，入队出队，关键点有两个：
         *
         * 判断当前出队的值，是否在剩下的里面优先级最高，这个可以用优先队列实现
         * 相同元素时，要保证原顺序，原顺序在前的优先级更高，这个就需要优先队列里存储原顺序
         * PriorityQueue<int[]> prior = new PriorityQueue<>((a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
         * 优先队列存储一个数组，数组的第一个元素是数值，第二个元素是出现顺序，构建大顶堆，相同元素的按出现顺序排列。
         *
         * 另外，输出结果是按原始数组的顺序输出其优先级，因此可以用一个数组来保存优先级顺序。
         *
         * 当出队元素与优先队列出队的元素一样时，存储优先级顺序
         * 当出队元素与优先队列出队元素不一样时，再分别重新入队
         */
    }
}
