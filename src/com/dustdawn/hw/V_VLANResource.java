package com.dustdawn.hw;

import java.util.*;

/**
 * VLAN资源池(100分)(排序+贪心区间)
 * 题目描述：
 * VLAN是一种对局域网设备进行逻辑划分的技术，为了标识不同的VLAN，引入VLAN ID(1-4094之间的整数)的概念。
 * 定义一个VLAN ID的资源池(下称VLAN资源池)，资源池中连续的VLAN用开始VLAN-结束VLAN表示，不连续的用单个整数表示，
 * 所有的VLAN用英文逗号连接起来。
 * 现在有一个VLAN资源池，业务需要从资源池中申请一个VLAN，需要你输出从VLAN资源池中移除申请的VLAN后的资源池。
 * 输入描述:
 * 第一行为字符串格式的VLAN资源池，第二行为业务要申请的VLAN，VLAN的取值范围为[1,4094]之间的整数。
 * 输出描述:
 * 从输入VLAN资源池中移除申请的VLAN后字符串格式的VLAN资源池，输出要求满足题目描述中的格式，并且按照VLAN从小到大升序输出。
 * 如果申请的VLAN不在原VLAN资源池内，输出原VLAN资源池升序排序后的字符串即可。
 * 备注：
 * 输入VLAN资源池中VLAN的数量取值范围为[2-4094]间的整数，资源池中VLAN不重复且合法([1,4094]之间的整数)，输入是乱序的。
 *
 * @author dustdawn
 * @date 2022/9/3 15:33
 */
public class V_VLANResource {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int n = Integer.parseInt(sc.nextLine());
        int[][] nums = new int[str.length][];
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            nums[i] = new int[2];
            String[] split = str[i].split("-");
            nums[i][0] = Integer.parseInt(split[0]);
            nums[i][1] = nums[i][0];
            if (split.length == 2) {
                nums[i][1] = Integer.parseInt(split[1]);
            }
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int end = nums[0][1];
        merge.add(nums[0]);
        for (int[] item : nums) {
            if (item[0] <= end) {
                end = Math.max(end, item[1]);
                merge.get(merge.size() - 1)[1] = end;
            } else {
                end = item[1];
                merge.add(item);
            }
        }
        int[][] array = merge.toArray(new int[merge.size()][]);
        StringBuilder sb = new StringBuilder();
        for (int[] item : array) {
            if (item[0] == item[1]) {
                if (item[0] != n) {
                    sb.append(item[0]).append(",");
                }
            } else {
                if (n == item[0]) {
                    item[0]++;
                } else if (n == item[1]) {
                    item[1]--;
                } else if (n > item[0] && n < item[1]) {
                    if (n - 1 == item[0]) {
                        sb.append(item[0]).append(",");
                    } else {
                        sb.append(item[0]).append("-").append(n - 1).append(",");
                    }
                    if (n + 1 == item[1]) {
                        sb.append(item[1]).append(",");
                    } else {
                        sb.append(n + 1).append("-").append(item[1]).append(",");
                    }
                } else {
                    sb.append(item[0]).append("-").append(item[1]).append(",");
                }
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
        /**
         * 示例 1：
         * 输入
         * 1-5
         * 2
         * 输出
         * 1,3-5
         * 说明
         * 原VLAN资源池中有VLAN 1、2、3、4、5，从资源池中移除2后，剩下VLAN 1、3、4、5，按照题目描述格式并升序后的结果为1,3-5。
         * 示例 2：
         * 输入
         * 20-21,15,18,30,5-10
         * 15
         * 输出
         * 5-10,18,20-21,30
         * 说明
         * 原VLAN资源池中有VLAN 5、6、7、8、9、10、15、18、20、21、30，从资源池中移除15后，资源池中剩下的VLAN
         * 为 5、6、7、8、9、10、18、20、21、30，按照题目描述格式并升序后的结果为5-10,18,20-21,30。
         * 示例 3：
         * 输入
         * 5,1-3
         * 10
         * 输出
         * 1-3,5
         * 说明
         * 原VLAN资源池中有VLAN 1、2、3，5，申请的VLAN 10不在原资源池中，将原资源池按照题目描述格式并按升序排序后
         * 输出的结果为1-3,5。
         */
    }
}
