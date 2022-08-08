package com.dustdawn.leetcode.datastructure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 855. 考场就座
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：
 * 其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；
 * 函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。
 * 每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 *
 * @author dustdawn
 * @date 2022/8/8 15:59
 */
public class ExamRoom {
    /**
     * 思路：每两个相邻的考生看作线段的两个端点，新安排考试就是找最长的线段，然后二分线段，重点即为分配的座位
     */
    // 将端点p映射到以p为左端点的线段
    private Map<Integer, int[]> startMap;
    // 将端点p映射到以p为右端点的线段
    private Map<Integer, int[]> endMap;
    // 根据线段长度从小到大存放所有线段
    private TreeSet<int[]> pq;
    private int N;

    public ExamRoom(int n) {
        this.N = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        // 动态过程中取最值，选择有序数据结构且可以删除修改任意值
        pq = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = distance(o1);
                int dist2 = distance(o2);
                // 如果长度相同，就比较索引
                if (dist1 == dist2) {
                    // 选择索引较小的
                    return o2[0] - o1[0];
                }
                return dist1 - dist2;
            }
        });
        // 在有序集合中先放入一个虚拟线段
        addInterval(new int[]{-1, N});
    }

    /**
     * 不能简单计算一条线段两个端点间的长度，而是让他计算改线段中点和端点之间的长度
     * @param intv
     * @return
     */
    private int distance(int[] intv) {
        int x = intv[0];
        int y = intv[1];
        if (x == -1) {
            return y;
        }
        if (y == N) {
            return N - 1 - x;
        }
        // 中点和端点之间的长度
        return (y - x) / 2;
    }

    /**
     * 增加线段
     *
     * @param intv
     */
    private void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    /**
     * 去除线段
     *
     * @param intv
     */
    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    public int seat() {
        // 从有序集合拿出最长的线段
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            // 情况一，最左边没人坐最左边
            seat = 0;
        } else if (y == N) {
            // 情况二，最右边没人坐最右边
            seat = N - 1;
        } else {
            // 情况三，不为边界时，就坐中间
            // (x + y) / 2 防溢出变形
            seat = x + (y - x) / 2;
        }
        // 将最长的线段分为两段
        int[] left = new int[]{x, seat};
        int[] right = new int[]{seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        // 将p左右的线段找出来
        int[] right = startMap.get(p);
        int[] left = endMap.get(p);
        // 将两条线段合并为一条线段
        int[] merged = new int[]{left[0], right[1]};
        // 删除旧线段，插入新线段
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }

    public static void main(String[] args) {
        /**
         * 示例：
         *
         * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
         * 输出：[null,0,9,4,2,null,5]
         * 解释：
         * ExamRoom(10) -> null
         * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
         * seat() -> 9，学生最后坐在 9 号座位上。
         * seat() -> 4，学生最后坐在 4 号座位上。
         * seat() -> 2，学生最后坐在 2 号座位上。
         * leave(4) -> null
         * seat() -> 5，学生最后坐在 5 号座位上。
         *  
         *
         * 提示：
         *
         * 1 <= N <= 10^9
         * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
         * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
         */
    }
}
