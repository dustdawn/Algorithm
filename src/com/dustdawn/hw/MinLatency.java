package com.dustdawn.hw;

import java.util.*;

/**
 * 最小传输时延(Dijkstra)
 * 题目描述
 * 某通信网络中有N个网络结点，用1到N进行标识。网络通过一个有向无环图表示，其中图的边的值表示结点之间的消息传递时延。
 * 现给定相连节点之间的时延列表times[i]={u，v，w}，其中u表示源结点，v表示目的结点，w表示u和v之间的消息传递时延。
 * 请计算给定源结点到目的结点的最小传输时延，如果目的结点不可达，返回-1。
 * 注：
 * N的取值范围为[1，100];
 * 时延列表times的长度不超过6000，且 1 <= u,v <= N，0 <= w <= 100;
 * 输入描述
 * 输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的长度M，用空格分隔；
 * 接下来的M行为两个结点间的时延列表[u v w];
 * 输入的最后一行为两个正整数，分别表示源结点和目的结点。
 * 输出描述
 * 起点到终点得最小时延，不可达则返回-1
 *
 * @author dustdawn
 * @date 2022/9/4 14:43
 */
public class MinLatency {
    /**
     * 示例
     * 输入
     * 3 3
     * 1 2 11
     * 2 3 13
     * 1 3 50
     * 1 3
     * 输出
     * 24
     * 思路分析
     * 典型的有向图的单源最短路径，可以使用Dijkstra算法计算起点到终点的最短时延。
     * 使用优先队列实现算法中每次取最短路径。
     * 提供两种连接关系的表示方法，包括邻接表和邻接矩阵。
     * 注：邻接矩阵表示的时候，不要赋值Integer.MAX_VALUE，会溢出，+1，变为负数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m][3];
        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            nums[i][2] = sc.nextInt();
        }
        int from = sc.nextInt();
        int to = sc.nextInt();
        // 按to最小排，优先取最短路径
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // dist[i]：到达i的最小时延
        int[] dist = new int[m + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[from] = 0;
        queue.add(new int[]{from, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < nums.length; i++) {
                // 列表中，起点与队列中节点相同
                if (nums[i][0] == poll[0]) {
                    int next = nums[i][1];
                    // from到达poll[0]的最短时延 + 列表中poll[0]为起点的时延
                    if (dist[next] > nums[i][2] + dist[poll[0]]) {
                        // 更新from到达next的最小时延
                        dist[next] = nums[i][2] + dist[poll[0]];
                        queue.add(new int[]{next, dist[next]});
                    }
                }
            }
        }
        if (dist[to] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[to]);
        }

    }
}
