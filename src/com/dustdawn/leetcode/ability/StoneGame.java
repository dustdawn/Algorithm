package com.dustdawn.leetcode.ability;

/**
 * 877. 石子游戏
 * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
 * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
 * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
 * 提示：
 * 2 <= piles.length <= 500
 * piles.length 是 偶数
 * 1 <= piles[i] <= 500
 * sum(piles[i]) 是 奇数
 *
 * @author dustdawn
 * @date 2022/8/8 17:01
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        // 石子堆数量为偶数，每个人的堆数一致。石子总数为奇数，不可能有相同多的石子
        // 技巧：观察奇数号堆的石子总数多还是偶数号堆的石子总数多不暴露出中间最数字最大的堆
        // 先手选择奇数号堆，往后只能拿奇数号堆，反之亦然
        return true;
    }

    /**
     * 动态规划
     *
     * @param piles
     * @return
     */
    public boolean stoneGame2(int[] piles) {
        int length = piles.length;
        /**
         * 2.dp数组：
         * dp[i][j]表示当剩下的石子堆为下标i到下标j时，即在下标范围[i, j][i, j]中，当前玩家与另一个玩家的石子数量之差的最大值
         */
        int[][] dp = new int[length][length];
        /**
         * 1.base case
         * 只有当i <= j时，剩下的石子堆才有意义，因此当i>j时，dp[i][j] = 0。
         * 当i=j时，只剩下一堆石子，当前玩家只能取走这堆石子，因此对于所有0 <= i < nums.length，都有dp[i][i] = piles[i]。
         *
         */
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                // 当 i<j 时，当前玩家可以选择取走piles[i]或piles[j]，然后轮到另一个玩家在剩下的石子堆中取走石子。
                // 在两种方案中，当前玩家会选择最优的方案，使得自己的石子数量最大化。因此可以得到如下状态转移方程：
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：piles = [5,3,4,5]
         * 输出：true
         * 解释：
         * Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
         * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
         * 如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
         * 如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
         * 这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
         * 示例 2：
         *
         * 输入：piles = [3,7,2,3]
         * 输出：true
         */
    }
}
