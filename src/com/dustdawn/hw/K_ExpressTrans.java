package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快递运输(100分)(排序+累加)
 * 一辆运送快递的货车，运送的快递均放在大小不等的长方体快递盒中，为了能够装载更多的快递，同时不能让货车超载，需要计算最多能装多少个快递。
 * 注：快递的体积不受限制，快递数最多1000个，货车载重最大50000。
 * 输入描述:
 * 一辆运送快递的货车
 * 第一行输入每个快递的重量，用英文逗号分隔，如：5,10,2,11
 * 第二行输入货车的载重量，如：20
 * 不需要考虑异常输入。
 * 输出描述:
 * 输入最多能装多少个快递，如：3
 *
 * @author dustdawn
 * @date 2022/9/9 22:51
 */
public class K_ExpressTrans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");        //把快递以逗号分割放入数组中
        int n = sc.nextInt();
        int len = strings.length;
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = Integer.valueOf(strings[i]);      //把字符串数组格式化为数字数组
        }
        Arrays.sort(ints);      //对快递进行从小到大排序
        int res = 0;
        int num = 0;
        for (int i = 0; i < len; i++) {
            res += ints[i];
            if (res > n) {      //若大于载重量则推出循环
                break;
            }
            num++;
        }
        System.out.println(num);
        /**
         * 输入
         * 5,10,2,11
         *
         * 20
         *
         * 输出
         * 3
         *
         * 说明
         * 货车的载重量为20，最多只能放三个快递5、10、2，因此输出3
         *
         * 解题思路：
         * 因为要装最多的货，所以货物的重量越轻越好。将货物从小到大排序，遍历相加，当大于载重量的时候退出。
         */
    }
}
