package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 数组拼接(100分)(循环计数)
 * 现在有多组整数数组，需要将它们合并成一个新的数组。合并规则，从每个数组里按顺序取出固定长度的内容合并到新的数组中，取完的内容会删除掉，如果该行不足固定长度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
 * 输入描述:
 * 第一行是每次读取的固定长度，0<长度<10
 * 第二行是整数数组的数目，0<数目<1000
 * 第3-n行是需要合并的数组，不同的数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素。
 * 输出描述:
 * 输出一个新的数组，用逗号分隔。
 *
 * @author dustdawn
 * @date 2022/9/9 21:58
 */
public class S_ArraySplicing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int step = sc.nextInt();
        int m = sc.nextInt();
        List<List<String>> lists = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] strings = sc.nextLine().split(",");
            lists.add(Arrays.asList(strings));  //将数组放入集合中
        }

        List<Integer> res = new ArrayList<>();
        int n = 0;  //起始下标
        int count = 0;  //取完数字的数组
        while (count < m) {    //当取完的数组数量小于m时进入循环
            for (int i = 0; i < m; i++) {
                List<String> list = lists.get(i);
                if (n > list.size()) {  //当其实下标大于数组长度时退出本次循环
                    continue;
                }
                int end = n + step; //结束位置下标
                if (end >= list.size()) {   //当结束位置下标大于等于数组长度时
                    end = list.size();
                    count++;    //取完数字数组数量+1
                }
                for (int j = n; j < end; j++) {
                    res.add(Integer.parseInt(list.get(j)));
                }
            }
            n += step;    //起始位置下标变更（+step）
        }

        System.out.println(res);

        /**
         * 示例1
         *
         * 输入
         *
         * 3
         *
         * 2
         *
         * 2,5,6,7,9,5,7
         *
         * 1,7,4,3,4
         *
         * 输出
         *
         * 2,5,6,1,7,4,7,9,5,3,4,7
         *
         * 说明
         *
         * 1、获得长度3和数组数目2。
         *
         * 2、先遍历第一行，获得2,5,6；
         *
         * 3、再遍历第二行，获得1,7,4；
         *
         * 4、再循环回到第一行，获得7,9,5；
         *
         * 5、再遍历第二行，获得3,4；
         *
         * 6、再回到第一行，获得7，按顺序拼接成最终结果。
         *
         * 示例2
         *
         * 输入
         *
         * 4
         *
         * 3
         *
         * 1,2,3,4,5,6
         *
         * 1,2,3
         *
         * 1,2,3,4
         *
         * 输出
         *
         * 1,2,3,4,1,2,3,1,2,3,4,5,6
         */
    }
}
