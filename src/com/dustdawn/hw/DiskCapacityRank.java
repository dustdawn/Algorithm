package com.dustdawn.hw;

import java.util.*;

/**
 * 磁盘容量排序(100分)(排序+哈希表)
 * 题目描述：
 * 磁盘的容量单位常用的有M，G，T这三个等级，它们之间的换算关系为1T = 1024G，1G = 1024M，
 * 现在给定n块磁盘的容量，请对它们按从小到大的顺序进行稳定排序，
 * 例如给定5块盘的容量，1T，20M，3G，10G6T，3M12G9M排序后的结果为20M，3G，3M12G9M，1T，10G6T。
 * 注意单位可以重复出现，上述3M12G9M表示的容量即为3M+12G+9M，和12M12G相等。
 * 输入描述：
 * 输入第一行包含一个整数n(2 <= n <= 100)，表示磁盘的个数，
 * 接下的n行，每行一个字符串(长度大于2，小于30)，表示磁盘的容量，
 * 由一个或多个格式为mv的子串组成，其中m表示容量大小，v表示容量单位，
 * 例如20M，1T，30G，10G6T，3M12G9M。
 * 磁盘容量m的范围为1到1024的正整数，容量单位v的范围只包含题目中提到的M，G，T三种，换算关系如题目描述。
 * 输出描述：
 * 输出n行，表示n块磁盘容量排序后的结果。
 *
 * @author dustdawn
 * @date 2022/9/5 17:34
 */
public class DiskCapacityRank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        // 一维数组保持原来序号
        int[][] num = new int[n][2];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int index = -1;
            String str = in.nextLine();
            map.put(i + 1, str);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'M') {
                    sum += Integer.parseInt(str.substring(index + 1, j));
                    index = j;
                } else if (str.charAt(j) == 'G') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024;
                    index = j;
                } else if (str.charAt(j) == 'T') {
                    sum += Integer.parseInt(str.substring(index + 1, j)) * 1024 * 1024;
                    index = j;
                }
            }
            num[i][0] = i + 1;
            num[i][1] = sum;
        }
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(map.get(num[i][0]));
            } else {
                System.out.println(map.get(num[i][0]));
            }
        }
        /**
         * 示例 1：
         * 输入
         * 3
         * 1G
         * 2G
         * 1024M
         * 输出
         * 1G
         * 1024M
         * 2G
         * 说明
         * 1G和1024M容量相等，稳定排序要求保留它们原来的相对位置，故1G在1024M之前
         *
         * 示例 2：
         * 输入
         * 3
         * 2G4M
         * 3M2G
         * 1T
         * 输出
         * 3M2G
         * 2G4M
         * 1T
         * 说明
         * 1T的容量大于2G4M，2G4M的容量大于3M2G
         *
         * 思路分析
         * 首先是对一个磁盘大小的计算，可以都换算成M，通过字符串分隔来计算磁盘大小。
         *
         * 然后是对磁盘的一个排序，还是使用二维数组，对于索引和大小进行排序，小的在前面，相等的索引在前面。还要找回对应的磁盘字符串，这里可以将索引和字符串存到一个哈希表里，方便查找。
         */
    }
}
