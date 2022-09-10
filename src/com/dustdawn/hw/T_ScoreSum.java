package com.dustdawn.hw;

import java.util.*;

/**
 * 统计射击比赛成绩(100分)(哈希表+列表+排序)
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高3个分数之和进行降序排名，输出降序排名后的选手ID序列。条件如下：
 * 1、一个选手可以有多个射击成绩的分数，且次序不固定。
 * 2、如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手。
 * 3、如果选手的成绩之和相等，则成绩之和相等的选手按照其ID降序排列。
 * 输入描述:
 * 输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数（2<=N<=100）。
 * 输入第二行，一个长度为N整数序列，表示参与每次射击的选手ID（0<=ID<=99）。
 * 输入第三行，一个长度为N整数序列，表示参与每次射击的选手对应的成绩（0<=成绩<=100）。
 * 输出描述:
 * 符合题设条件的降序排名后的选手ID序列。
 *
 * @author dustdawn
 * @date 2022/9/6 21:13
 */
public class T_ScoreSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s1 = sc.nextLine().split(","); //队员
        String[] s2 = sc.nextLine().split(","); //射击成绩
        Map<Integer, List<Integer>> map = new HashMap<>();
        /**
         * 队员作为key值，成绩作为value值（集合）
         */
        for (int i = 0; i < n; i++) {
            int key = Integer.valueOf(s1[i]);
            int value = Integer.valueOf(s2[i]);
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(key, list);
            }
        }
        /**
         * 将队员id及最高三个成绩之和放入集合list
         * 将所有队员数据放在集合lists
         */
        List<List<Integer>> lists = new ArrayList<>();
        map.forEach((a, b) -> {
            List<Integer> list = new ArrayList<>();
            if (b.size() >= 3) {    //成绩大于等于3才有效
                Collections.sort(b);    //升序排序（从小到大）
                list.add(a);    //a为队员id
                //取倒数三个成绩之和为总成绩
                list.add(b.get(b.size() - 1) + b.get(b.size() - 2) + b.get(b.size() - 3));
            }
            lists.add(list);
        });

        lists.sort((a, b) -> {
            if (b.get(1) > a.get(1)) {  //成绩高的在前
                return 1;
            }
            if (b.get(0) > a.get(0)) {  //成绩相等时，id高的在前
                return 1;
            }
            return -1;
        });

        String res = "";
        for (int i = 0; i < lists.size() - 1; i++) {
            res += lists.get(i).get(0) + ",";   //各队员成绩的第一个数为其id
        }
        System.out.println(res + lists.get(lists.size() - 1).get(0));

        /**
         * 示例1
         *
         * 输入
         *
         * 13
         *
         * 3,3,7,4,4,4,4,7,7,3,5,5,5
         *
         * 53,80,68,24,39,76,66,16,100,55,53,80,55
         *
         * 输出
         *
         * 5,3,7,4
         *
         * 说明
         *
         * 该场射击比赛进行了13次，参赛的选手为{3,4,5,7}。
         * 3号选手成绩：53,80,55，最高3个成绩的和为：80+55+53=188。
         * 4号选手成绩：24,39,76,66，最高3个成绩的和为：76+66+39=181。
         * 5号选手成绩：53,80,55，最高3个成绩的和为：80+55+53=188。
         * 7号选手成绩：68,16,100，最高3个成绩的和为：100+68+16=184。
         * 比较各个选手最高3个成绩的和，有3号=5号>7号>4号，由于3号和5号成绩相等且ID号5>3，所以输出为：5,3,7,4
         */
    }

}
