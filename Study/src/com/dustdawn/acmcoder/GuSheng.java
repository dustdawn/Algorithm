package com.dustdawn.acmcoder;

/**
 * @author dustdawn
 * @date 2019/8/29 19:39
 */
public class GuSheng {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            calculate(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            calculate2(arr[i]);
        }




    }
    public static void calculate(int day) {
        //初始单价为1
        int price = 1;
        //降价的天数
        /**
         * 第3,6,10,15天为降价，相邻数的差满足d为1的等差数列
         * an - a1 = (n+1) + ... +3;
         * an = 3 + (n+1-3+1)(n+1+3)/2 = (n^2 + 3*n + 2)/2
         */
        int downDay = 3;//downDay = an
        int downNum = 1;//downNum = n

        //方法一：时间复杂度1
        //遍历天数
        for(int i = 2;i <= day;i++) {
            if(i == downDay) {
                downNum++;
                downDay = (downNum*downNum+3*downNum+2)/2;
                price--;
            }else {
                price++;
            }
        }
        System.out.println(price);

    }
    public static void calculate2(int day) {
        //方法二：根据求根公式根据day算出最大的n
        //n = -3+根号(1+8*day)/2

        int price;
        int downNum;//downNum = n

        //求出n后根据规律可知price = day - 2 * 已经出现的降价天数的次数
        downNum = (int) (Math.sqrt(1+8*day)/2  - 1.5);
        price = day - 2*downNum;
        System.out.println(price);
    }


}
