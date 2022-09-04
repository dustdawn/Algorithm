package com.dustdawn.hw;

import java.util.*;

/**
 * 最长广播效应
 * 题目描述
 * 某通信网络中有N个网络结点，用1到N进行标识。
 * 网络中的结点互联互通，且结点之间的消息传递有时延，相连结点的时延均为一个时间单位。
 * 现给定网络结点的连接关系link[i]={u，v}，其中u和v表示网络结点。
 * 当指定一个结点向其他结点进行广播，所有被广播结点收到消息后都会在原路径上回复一条响应消息，
 * 请计算发送结点至少需要等待几个时间单位才能收到所有被广播结点的响应消息。
 * 注：
 * N的取值范围为[1，100];
 * 连接关系link的长度不超过3000，且1 <= u,v <= N;
 * 网络中任意结点间均是可达的;
 * 输入描述
 * 输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的长度T；
 * 接下来的T行输入，表示结点间的连接关系列表；
 * 最后一行的输入为一个正整数，表示指定的广播结点序号；
 * 输出描述
 * 输出一个整数，表示发送结点接收到所有响应消息至少需要等待的时长。
 *
 * @author dustdawn
 * @date 2022/9/4 16:20
 */

public class LongestBroadcast {
    /**
     * 示例
     * 输入
     * 5 7
     * 1 4
     * 2 1
     * 2 3
     * 2 4
     * 3 4
     * 3 5
     * 4 5
     * 2
     * 输出
     * 4
     * 说明
     * 结点2到5的最小时延为2，到剩余结点的最小时延均为1，所以至少要等待2*2=4s。
     * 思路分析
     * 单源最短路径问题，找到起始点到其它节点的最短路径的最大值乘2即可。可以使用BFS、DFS或者dijkstra算法。
     * 这里使用BFS算法实现。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int start = sc.nextInt();
        int[] dist = new int[count + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < n; i++) {
                if (nums[i][0] == poll[0]) {
                    int next = nums[i][1];
                    if (dist[next] > dist[poll[0]] + 1) {
                        dist[next] = dist[poll[0]] + 1;
                        queue.offer(new int[]{next, dist[next]});
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < count + 1; i++) {
            ans = Math.max(ans, dist[i]);
        }
        System.out.println(ans << 1);
    }
}
