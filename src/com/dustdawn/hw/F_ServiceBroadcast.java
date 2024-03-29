package com.dustdawn.hw;

import java.util.*;

/**
 * 服务器广播(200分)(哈希表)
 * 题目描述：
 * 服务器连接方式包括直接相连，间接连接。A 和 B 直接连接，B 和 C 直接连接，则 A 和 C 间接连接。
 * 直接连接和间接连接都可以发送广播。
 * 给出一个 N*N 数组，代表 N 个服务器，matrix[i][j]==1，则代表 i 和 j 直接连接；
 * 不等于 1 时，代表 i 和 j 不直接连接。
 * matrix[i][i]==1，即自己和自己直接连接。matrix[i][j]==matrix[j][i]。
 * 计算初始需要给几台服务器广播，才可以使每个服务器都收到广播。
 * 输入描述
 * 输入为N行，每行有N个数字，为0或1，由空格分隔，构成N*N的数组，N的范围为 1<=N<=50
 * 输出描述
 * 输出一个数字，为需要广播的服务器数量
 *
 * @author dustdawn
 * @date 2022/9/5 13:36
 */
public class F_ServiceBroadcast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = str.length;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {  // 把第一行加入arr
            arr[0][i] = Integer.parseInt(str[i]);
        }
        for (int i = 1; i < n; i++) {  // 把剩下的行加入arr
            String[] s = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int mapKey = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isContain = false;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if (entry.getValue().contains(i)) {
                    isContain = true;
                    mapKey = entry.getKey();
                }
            }
            if (!isContain) {
                map.put(i, new ArrayList<>());
                mapKey = i;
            }
            for (int j = i; j < arr.length; j++) {
                if (i != j && arr[i][j] == 1) {
                    map.get(mapKey).add(j);
                }
            }
        }
        System.out.println(map.size());
        /**
         * map
         *   key:第一个节点
         *   value:可以联通的节点
         * 列如：
         *      1、2联通  key:1,value:2
         *      如果2、3也联通，则遍历map中的value是否包含2
         *      如果包含则在对应的key中的value值添加3
         *      以此类推
         *      最后map的长度则是需要广播的台数
         */
        /**
         * 示例 1：
         * 输入
         * 1 0 0
         * 0 1 0
         * 0 0 1
         * 输出
         * 3
         * 说明
         * 3台服务器互不连接，所以需要分别广播这3台服务器
         *
         * 示例 1：
         * 输入
         * 1 1
         * 1 1
         * 输出
         * 1
         * 说明
         * 2台服务器相互连接，所以只需要广播其中一台服务器
         *
         * 思路分析：
         * 从第一个开始判断，依次将直连的服务器加进来
         * 从1找到的集合中依次将直连的服务器加进来，直到集合没有变化
         * 获取1集合中不存在的服务器，重复以上步骤
         * 上述集合的个数，就是需要发出广播的服务器数量
         */
    }
}
