package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 数字反转打印(200分)(规律+List)
 * 小华是个很有对数字很敏感的小朋友，他觉得数字的不同排列方式有特殊美感。某天，小华突发奇想，如果数字多行排列，
 * 第一行1个数，第二行2个，第三行3个，即第n行有n个数字，并且奇数行正序排列，偶数行逆序排列，数字依次累加。这样排列的数字一定很有意思。
 * 聪明的你能编写代码帮助小华完成这个想法吗？
 * 规则总结如下：
 * a、每个数字占据4个位置，不足四位用‘*’补位，如1打印为1***。
 * b、数字之间相邻4空格。
 * c、数字的打印顺序按照正序逆序交替打印,奇数行正序，偶数行逆序。
 * d、最后一行数字顶格，第n-1行相对第n行缩进四个空格
 * 输入描述:
 * 第一行输入为N，表示打印多少行; 1<=N<=30
 * 输入：2
 * 输出描述:
 * XXXX1***
 * 3***XXXX2***
 *
 * @author dustdawn
 * @date 2022/9/10 13:23
 */
public class S_DigitReverse {
    public static int firstNum(int n) {
        if (n == 1) {
            return 1;
        }
        return firstNum(n - 1) + n - 1;       //根据规律推出第n行的头为n-1的头加上n-1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> lists = new ArrayList<>();
        for (int i = 1; i <= n; i++) {      //为了方便i初始值设为1
            List<String> list = new ArrayList<>();
            int fn = firstNum(i);     //先计算出行头数字
            lists.forEach(x -> {
                x.add(0, "    ");        //每加一行，前面的所有行前面都加一个"    "
            });
            for (int j = 0; j < i; j++) {
                String temp = fn++ + "***";        //每个数后面都加三个*，因为至少一位数，所以只要加三个
                list.add(temp.substring(0, 4));     //头数向后递加，只取前面四个字符串
                if (j != i - 1) {
                    list.add("    ");       //除了最后一个数，其余全部加上"    "
                }
            }
            if ((i) % 2 == 0) {
                Collections.reverse(list);      //偶数行进行翻转
            }
            lists.add(list);
        }

        lists.forEach(x -> {
            String res = "";        //把所有行转化成字符串类型
            for (int i = 0; i < x.size(); i++) {
                res += x.get(i);
            }
            System.out.println(res);
        });

        /**
         * 示例1
         *
         * 输入
         *
         * 2
         *
         * 输出
         *
         *     1***
         *
         * 3***    2***
         *
         * 备注:
         *
         * 符号*表示，数字不满4位时的补位，符号X表示数字之间的空格。注意实际编码时不需要打印X，直接打印空格即可。此处为说明题意，故此加上X
         *
         * 解题思路：
         * 根据题目所示，得出的数据应该如下图所示：
         *
         *             1***
         *
         *         3***    2***
         *
         *     4***    5***    6***
         *
         * 10**    9***    8***    7***
         *
         * ........................................
         *
         * 从上图可以得到规律：
         *
         * 第n行的最小数字 = 第n-1行的最小数字+第n-1行的行数（n-1）
         *
         * 得到n行的最小数字之后再通过n次递增，就会获取n行的所有数字
         */
    }
}
