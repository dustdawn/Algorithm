package com.dustdawn.hw;

import java.util.*;

/**
 * 字符串统计（全量和占用字符集）(哈希表)
 * 题目描述：
 * 给定两个字符集合， 一个是全量字符集， 一个是已占用字符集， 已占用字符集中的字符不能再使用， 要求输出剩余可用字符集。
 * 输入描述:
 * 输入一个字符串 一定包含@，@前为全量字符集 @后的为已占用字符集
 * 已占用字符集中的字符，一定是全量字符集中的字符，字符集中的字符跟字符之间使用英文逗号隔开
 * 每个字符都表示为字符+数字的形式，用英文冒号分隔，比如a:1标识一个a字符
 * 字符只考虑英文字母，区分大小写，数字只考虑正整型 不超过100
 * 如果一个字符都没被占用，@标识仍存在
 * 输出描述:
 * 输出可用字符集，
 * 不同的输出字符集之间用回车换行，
 * 注意：输出的字符顺序要跟输入的一致，不能输出b:3,a:2,c:2
 * 如果某个字符已全部占用，则不需要再输出
 *
 * @author dustdawn
 * @date 2022/9/3 16:21
 */
public class StringStatistics {
    /**
     * 示例 1：
     * 输入
     * a:3,b:5,c:2@a:1,b:2
     * 输出
     * a:2,b:3,c:2
     * 说明：
     * 全量字符集为三个a，5个b，2个c
     * 已占用字符集为1个a，2个b
     * 由于已占用字符不能再使用
     * 因此剩余可用字符为2个a，3个b，2个c
     * 示例 2：
     * 输入
     * a:3,b:5,c:2@
     * 输出
     * a:3,b:5,c:2@
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("@");
        String[] nums = arr[0].split(",");
        if (arr.length == 1) {
            System.out.println(arr[0] + "@");
            return;
        }
        String[] subs = arr[1].split(",");
        Map<String, Integer> data = new LinkedHashMap<>();
        for (String num : nums) {
            String[] split = num.split(":");
            data.put(split[0], Integer.parseInt(split[1]));
        }
        Map<String, Integer> subMap = new HashMap<>();
        for (String sub : subs) {
            String[] split = sub.split(":");
            subMap.put(split[0], Integer.parseInt(split[1]));
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = data.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (subMap.containsKey(key)) {
                data.put(key, data.get(key) - subMap.get(key));
            }
            sb.append(key).append(":").append(data.get(key)).append(",");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
