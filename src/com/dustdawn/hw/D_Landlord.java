package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 斗地主之顺子(200分)(List+模拟)
 * 在斗地主扑克牌游戏中， 扑克牌由小到大的顺序为：3,4,5,6,7,8,9,10,J,Q,K,A,2，玩家可以出的扑克牌阵型有：单张、对子、顺子、飞机、炸弹等。
 * 其中顺子的出牌规则为：由至少5张由小到大连续递增的扑克牌组成，且不能包含2。
 * 例如：{3,4,5,6,7}、{3,4,5,6,7,8,9,10,J,Q,K,A}都是有效的顺子；而{J,Q,K,A,2}、 {2,3,4,5,6}、{3,4,5,6}、{3,4,5,6,8}等都不是顺子。
 * 给定一个包含13张牌的数组，如果有满足出牌规则的顺子，请输出顺子。
 * 如果存在多个顺子，请每行输出一个顺子，且需要按顺子的第一张牌的大小（必须从小到大）依次输出。
 * 如果没有满足出牌规则的顺子，请输出No。
 * 输入描述:
 * 13张任意顺序的扑克牌，每张扑克牌数字用空格隔开，每张扑克牌的数字都是合法的，并且不包括大小王：
 * 2 9 J 2 3 4 K A 7 9 A 5 6
 * 不需要考虑输入为异常字符的情况
 * 输出描述:
 * 组成的顺子，每张扑克牌数字用空格隔开：
 * 3 4 5 6 7
 *
 * @author dustdawn
 * @date 2022/9/10 16:24
 */
public class D_Landlord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int len = s.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) { //提出2，转化A,J,Q,K
            switch (s[i]) {
                case "J":
                    list.add(11);
                    break;
                case "Q":
                    list.add(12);
                    break;
                case "K":
                    list.add(13);
                    break;
                case "A":
                    list.add(14);
                    break;
                case "2":
                    break;
                default:
                    list.add(Integer.valueOf(s[i]));
            }
        }

        Collections.sort(list); //从小到大排序方便取值2 9 J 10 2 3 4 K A 7 Q A 5 6
        List<List<Integer>> ress = new ArrayList<>();
        boolean isA = false; //是否遍历完整个数组
        while (!isA) {
            List<Integer> res = new ArrayList<>();
            res.add(list.get(0));   //放入第一个数字
            int count = 1;
            for (int i = 1; i < list.size(); i++) {
                int x = list.get(i);    //  本次数字
                if (x == list.get(i - 1) + 1) { //符合严格递增
                    count++;
                    res.add(x);
                } else if (x == list.get(i - 1) && i != list.size() - 1) {
                    continue;   // 本次数字等于前面一个数字且不是数组最后一位,则进入下次循环
                }
                if (x != list.get(i - 1) + 1 || i == list.size() - 1) {
                    if (count >= 5) {   //符合顺子
                        ress.add(res);
                    } else if (i == list.size() - 1) {   //整个数组遍历完全，直接退出
                        isA = true;
                        break;
                    }
                    for (int j = 0; j < res.size(); j++) {
                        for (int k = 0; k < list.size(); k++) {
                            if (res.get(j) == list.get(k)) {
                                list.remove(k); //剔除已经处理过的数字
                                break;
                            }
                        }
                    }
                    if (list.size() < 5) {  //集合剩余数字不满足成为顺子
                        isA = true;
                    }
                    break;  //顺子已经提取，跳出本次循环
                }
            }
        }

        if (ress.size() == 0) {
            System.out.println("No");
        } else {
            for (int i = 0; i < ress.size(); i++) {
                String stringRes = "";
                for (int j = 0; j < ress.get(i).size(); j++) {
                    switch (ress.get(i).get(j)) {    //将A\J\Q\K还原
                        case 11:
                            stringRes += "J";
                            break;
                        case 12:
                            stringRes += "Q";
                            break;
                        case 13:
                            stringRes += "K";
                            break;
                        case 14:
                            stringRes += "A";
                            break;
                        default:
                            stringRes += ress.get(i).get(j);
                    }
                    if (j < ress.get(i).size() - 1) {
                        stringRes += " ";
                    }
                }
                System.out.println(stringRes);
            }
        }
        /**
         * 示例1
         *
         * 输入
         *
         * 2 9 J 2 3 4 K A 7 9 A 5 6
         *
         * 输出
         *
         * 3 4 5 6 7
         *
         * 说明
         *
         * 13张牌中，可以组成的顺子只有1组：3 4 5 6 7
         */
    }
}
