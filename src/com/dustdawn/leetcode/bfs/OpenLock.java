package com.dustdawn.leetcode.bfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * 提示：
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 *
 * @author dustdawn
 * @date 2022/6/16 21:14
 */
public class OpenLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        // 快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        // 记录已经穷举过的密码，防止走回头路。如0000拨到1000，从队列中拿出1000时还会拨出一个0000产生死循环
        Set<String> visited = new HashSet<>();
        // 初始化起点和终点
        q1.add("0000");
        q2.add(target);
        int step = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> tempForSwap = q1;
                q1 = q2;
                q2 = tempForSwap;
            }
            // 在遍历的过程中不能呢个修改哈希集合
            // 用temp存储q1的扩散结果
            Set<String> temp = new HashSet<>();
            /*
             * 将q1中的所有节点向周围扩散
             * 如最初的0000开始可以穷举出1000 0100 0010 0001 9000...等8种密码
             * 相当于一个图，每个节点有8个相邻的节点，要求求最短距离即BFS
             */
            for (String cur : q1) {
                // 判断密码是否合法
                if (deads.contains(cur)) {
                    continue;
                }
                // 判断是否到达终点
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);
                // 将一个节点的未遍历相邻节点加入集合 2 * 4 = 8
                for (int i = 0; i < 4; i++) {
                    String up = plusOne(cur, i);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, i);
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            // 增加步数
            step++;
            // temp（如第一次是扩散后的8个节点）相当于q1
            // 交换q1和q2，下一轮while会扩散q2（目标改为拨到temp的情况，双向扩散出现交集时，即找到了最短距离）
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    /**
     * 将s[i]向上拨动一次
     *
     * @param s
     * @param i
     * @return
     */
    private static String plusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] += 1;
        }
        return new String(ch);
    }

    /**
     * 将s[i]向下拨动一次
     *
     * @param s
     * @param i
     * @return
     */
    private static String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] -= 1;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        /**
         * 示例 1:
         *
         * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
         * 输出：6
         * 解释：
         * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
         * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
         * 因为当拨动到 "0102" 时这个锁就会被锁定。
         * 示例 2:
         *
         * 输入: deadends = ["8888"], target = "0009"
         * 输出：1
         * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
         * 示例 3:
         *
         * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
         * 输出：-1
         * 解释：无法旋转到目标数字且不被锁定。
         */
    }
}
