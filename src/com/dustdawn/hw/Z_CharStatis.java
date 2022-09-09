package com.dustdawn.hw;

import java.util.*;

/**
 * 字符统计及重排(100分)(排序+统计)
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，并按照字母出现次数从大到小的顺序输出各个字母及其出现次数。
 * 如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
 * 输入描述:
 * 输入一行，为一个仅包含字母的字符串。
 * 输出描述:
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号；字母和次数间用英文冒号分隔。
 *
 * @author dustdawn
 * @date 2022/9/9 22:17
 */
public class Z_CharStatis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);     //将输入内容转成键值对
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> {
            if (b.getValue() > a.getValue()) {      //按出现次数顺序排序
                return 1;
            }
            if (b.getValue() < a.getValue()) {      //按出现次数顺序排序
                return -1;
            }
            if (Character.isLowerCase((b.getKey())) && Character.isUpperCase(a.getKey())) {     //限制小写在前
                return 1;
            }
            if (Character.isLowerCase((a.getKey())) && Character.isUpperCase((b.getKey()))) {     //限制小写在前
                return -1;
            }
            if (b.getKey() < a.getKey()) {       //按字母顺序排序
                return 1;
            }
            return -1;
        });

        String res = "";
        for (int i = 0; i < entryList.size(); i++) {
            res += entryList.get(i).getKey() + ":";
            res += entryList.get(i).getValue() + ";";
        }

        System.out.println(res);

        /**
         * 示例1
         *
         * 输入
         *
         * xyxyXX
         *
         * 输出
         *
         * x:2;y:2;X:2;
         *
         * 说明
         *
         * 每个字符出现的个数都是2，故x排在y之前，而小写字母x在X之前
         *
         * 示例2
         *
         * 输入
         *
         * abababb
         *
         * 输出
         *
         * b:4;a:3;
         *
         * 说明
         *
         * b的出现个数比a多，故b排在a之前
         */
    }
}
