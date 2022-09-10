package com.dustdawn.hw;

import java.util.*;

/**
 * 欢乐的周末(200分)(多源BFS+队列)
 * 小华和小为是很要好的朋友，他们约定周末一起吃饭。通过手机交流，他们在地图上选择了多个聚餐地点（由于自然地形等原因，部分聚餐地点不可达），求小华和小为都能到达的聚餐地点有多少个？
 * 输入描述:
 * 第一行输入m和n，m代表地图的长度，n代表地图的宽度。
 * 第二行开始具体输入地图信息，地图信息包含：
 * 0 为通畅的道路
 * 1 为障碍物（且仅1为障碍物）
 * 2 为小华或者小为，地图中必定有且仅有2个 （非障碍物）
 * 3 为被选中的聚餐地点（非障碍物）
 * 输出描述:
 * 可以被两方都到达的聚餐地点数量，行末无空格。
 *
 * @author dustdawn
 * @date 2022/9/10 13:36
 */
public class H_HappyWeekend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m][n];
        int[][] people = new int[2][2];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int next = sc.nextInt();
                if (next == 2) {
                    people[index++] = new int[]{i, j};
                }
                nums[i][j] = next;
            }
        }
        // 图的多源BFS
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        int res = 0;
        int[][][] map = new int[2][m][n];
        for (int i = 0; i < 2; i++) {
            map[i] = new int[m][n];
            for (int j = 0; j < m; j++) {
                map[i][j] = Arrays.copyOf(nums[j], n);
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int in = 0; in < 2; in++) {
            int x = people[in][0];
            int y = people[in][1];
            int[][] copy = map[in];
            copy[x][y] = 0;
            // 污染源入队列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (copy[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            int[] poll = null;
            while (!queue.isEmpty()) {
                poll = queue.poll();
                // 四个方向BFS
                for (int i = 0; i < 4; i++) {
                    int newX = poll[0] + dx[i];
                    int newY = poll[1] + dy[i];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || copy[newX][newY] != 0 && copy[newX][newY] != 3) {
                        continue;
                    }
                    if (copy[newX][newY] == 3) {
                        copy[newX][newY] = 4;
                        if (in == 0) {
                            list.add(new int[]{newX, newY});
                        } else {
                            for (int[] arr : list) {
                                if (arr[0] == newX && arr[1] == newY) {
                                    res++;
                                }
                            }
                        }
                    } else {
                        copy[newX][newY] = 2;
                    }
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        System.out.println(res);

        /**
         * 示例1
         *
         * 输入：
         *
         * 4 4
         *
         * 2 1 0 3
         *
         * 0 1 2 1
         *
         * 0 3 0 0
         *
         * 0 0 0 0
         *
         * 输出：
         *
         * 2
         *
         * 说明：
         *
         * 第一行输入地图的长宽为3和4。
         *
         * 第二行开始为具体的地图，其中：3代表小华和小明选择的聚餐地点；2代表小华或者小明（确保有2个）；0代表可以通行的位置；1代表不可以通行的位置。此时两者能都能到达的聚餐位置有2处
         *
         * 示例2
         *
         * 输入：
         *
         * 4 4
         *
         * 2 1 2 3
         *
         * 0 1 0 0
         *
         * 0 1 0 0
         *
         * 0 1 0 0
         *
         * 输出：
         *
         * 0
         *
         * 说明：
         *
         * 第一行输入地图的长宽为4和4。
         *
         * 第二行开始为具体的地图，其中：3代表小华和小明选择的聚餐地点；2代表小华或者小明（确保有2个）；0代表可以通行的位置；1代表不可以通行的位置。由于图中小华和小为之间有个阻隔，此时，没有两人都能到达的聚餐地址，故而返回0
         *
         * 备注:
         *
         * 地图的长宽为m和n，其中：
         *
         * 4 <= m <= 100
         *
         * 4 <= n <= 100
         *
         * 聚餐的地点数量为 k，则
         *
         * 1< k <= 100
         */
    }
}
