package com.dustdawn.hw;

import java.util.Scanner;

/**
 * 连续出牌数量(200分)(dfs回溯)
 * 题目描述
 * 手里给一副手牌，数字从0-9，有r(红色),，g(绿色），b(蓝色)，y(黄色)四种颜色，出牌规则为每次打出的牌必须跟上一张的数字或者颜色相同，否则不能抽选。
 * 选手应该怎么选才能使得抽选的次数最大，并且输出这个最大次数。
 * 输入描述
 * 第一行 牌的数值n (1<=n<=9)
 * 第二行 牌的颜色（r,g,b,y四种颜色表示)
 * 输出描述
 * 输出最大出牌数量
 *
 * @author dustdawn
 * @date 2022/9/4 20:48
 */
public class L_NumberOfCard {
    /**
     * 示例
     * 输入
     * 1 4 3 4 5
     * r y b b r
     * 输出
     * 3
     * 说明
     * 如果打（1, r）-> (5, r)，那么能打两张。
     * 如果打（4，y) -> (4, b) -> (3, b)，那么能打三张。
     * 思路分析
     * 这道题可以考虑DFS
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str1 = in.nextLine().split(" ");
        String[] str2 = in.nextLine().split(" ");
        int n = str1.length;
        boolean[] used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(str1, str2, i, used, 1));
        }
        System.out.println(ans);

    }

    /**
     * 出牌次数
     *
     * @param s1   数字
     * @param s2   颜色
     * @param i    第i张牌
     * @param used 第i张牌是否已使用
     * @param ans  出牌次数
     * @return
     */
    public static int dfs(String[] s1, String[] s2, int i, boolean[] used, int ans) {
        if (i >= used.length || used[i]) {
            return ans - 1;
        }
        int res = ans;
        used[i] = true;
        for (int j = 0; j < used.length; j++) {
            // 判断其他牌是否可以连续出
            if (i != j && !used[j]) {
                if (s1[i].equals(s1[j]) || s2[i].equals(s2[j])) {
                    int temp = dfs(s1, s2, j, used, ans + 1);
                    res = Math.max(res, temp);
                }
            }
        }
        used[i] = false;
        return res;
    }
}
