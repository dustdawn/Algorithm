package com.dustdawn.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 日志排序(100分)(字符串+排序)
 * 运维工程师采集到某产品现网运行一天产生的日志N条，现需根据日志时间按时间先后顺序对日志进行排序。
 * 日志时间格式为：
 * H:M:S.N
 * H表示小时(0-23)，M表示分钟(0-59)，S表示秒(0-59)，N表示毫秒(0-999)
 * 时间可能并没有补齐，也就是说: 01:01:01.001，也可能表示为1:1:1.1
 * 输入描述:
 * 第一行输入一个整数N，表示日志条数，1<=N<=100000
 * 接下来N行输入N个时间
 * 输出描述:
 * 按时间升序排序之后的时间
 * 如果有两个时间表示的时间相同，则保持输入顺序
 *
 * @author dustdawn
 * @date 2022/9/6 15:25
 */
public class R_LogSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] nums = new String[n][4];
        for (int i = 0; i < n; i++) {
            String[] str = sc.nextLine()
                    .replace(".", ":")
                    .split(":");
            for (int j = 0; j < str.length; j++) {
                nums[i][j] = str[j];
            }
        }
        Arrays.sort(nums, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int a1 = Integer.parseInt(o1[0]);
                int a2 = Integer.parseInt(o1[1]);
                int a3 = Integer.parseInt(o1[2]);
                int a4 = Integer.parseInt(o1[3]);
                int b1 = Integer.parseInt(o2[0]);
                int b2 = Integer.parseInt(o2[1]);
                int b3 = Integer.parseInt(o2[2]);
                int b4 = Integer.parseInt(o2[3]);
                if (a1 == b1) {
                    if (a2 == b2) {
                        if (a3 == b3) {
                            return a4 - b4;
                        } else {
                            return a3 - b3;
                        }
                    } else {
                        return a2 - b2;
                    }
                } else {
                    return a1 - b1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                sb.append(nums[i][j]).append(":");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        System.out.print(sb);
        /**
         * 示例1
         *
         * 输入：
         *
         * 2
         *
         * 01:41:8.9
         *
         * 1:1:09.211
         *
         * 输出：
         *
         * 1:1:09.211
         *
         * 01:41:8.9
         *
         * 示例2
         *
         * 输入：
         *
         * 3
         *
         * 23:41:08.023
         *
         * 1:1:09.211
         *
         * 08:01:22.0
         *
         * 输出：
         *
         * 1:1:09.211
         *
         * 08:01:22.0
         *
         * 23:41:08.023
         *
         * 示例3
         *
         * 输入：
         *
         * 2
         *
         * 22:41:08.023
         *
         * 22:41:08.23
         *
         * 输出：
         *
         * 22:41:08.023
         *
         * 22:41:08.23
         *
         * 说明：
         *
         * 两个时间表示的时间相同，保持输入顺序
         *
         * 解题思路：
         *         将日志时间按照时、分、秒、毫秒分割，然后再按照时、分、秒、毫秒进行比较大小，
         *         如果时相同，则对分比较，如果分相同，则对秒进行比较，如果秒相同，则对毫秒进行比较，
         *         如果毫秒也相同，则顺序不变
         */
    }
}
