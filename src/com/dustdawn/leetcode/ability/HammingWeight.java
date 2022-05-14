package com.dustdawn.leetcode.ability;

/**
 * 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * @author dustdawn
 * @date 2022/2/27 16:20
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        // 规律：n与n-1作与运算&，使得n中为1的最低位反转成0，如01&00=00(1&0=0)，10&01=00(2&1=0)，11&10=10(3&2=2)
        // 无论如何，二进制为1的最低位都反转成0，反转的次数即为1的次数
        if (n == 0) {
            return 0;
        }
        int count = 1;
        while ((n = n & (n - 1)) != 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：00000000000000000000000000001011
         * 输出：3
         * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
         * 示例 2：
         *
         * 输入：00000000000000000000000010000000
         * 输出：1
         * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
         * 示例 3：
         *
         * 输入：11111111111111111111111111111101
         * 输出：31
         * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
         */
    }
}