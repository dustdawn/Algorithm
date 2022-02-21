package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/21 16:17
 */

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * <p>
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * <p>
 * 输出描述:
 * <p>
 * 输出答案。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 8
 * <p>
 * 输出
 * 复制
 * <p>
 * 18
 */
public class cutRope {

    /*思路
        将target分解成长度为a和b的两段，
     */
    public int cutRope(int target) {
        if (target == 2) {//长度为1时往下分段乘积最大为2
            return 1;
        }
        if (target == 3) {//长度为3时往下分段乘积最大为2
            return 2;
        }
        int dp[] = new int[target + 1];//dp[i]代表着长度为i时分段能获得的段最大乘积
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int temp = 0;
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                temp = dp[j] * (i - j);//选择分成长度为j的子段时的乘积
                dp[i] = Math.max(dp[i], temp); //取分段和不分段的两种情况中乘积最大值的一个
            }
        }
        return dp[target];
    }
}
