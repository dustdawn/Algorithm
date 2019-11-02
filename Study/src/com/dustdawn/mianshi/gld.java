package com.dustdawn.mianshi;

import java.util.Arrays;

/**
 * @author dustdawn
 * @date 2019/9/13 20:05
 */
public class gld {
    //第一题：输入一个N，输出1-2+3-4+5-6+7......N的值。
    public static int f1(int n) {
        //1.遍历
        /*int result = 0;
        for (int i = 1; i <= n; ++i) {
            if ((i & 1) == 1) {//奇数
                result += i;
            }else {
                result -= i;
            }
        }
        return result;*/
        //2.复杂度低
        if (n <= 0) {
            return 0;
        }
        int r = (n+1) / 2;
        int flag = (n & 1) == 1 ? 1 : -1;
        return r*flag;
    }
    //第二题：数组相邻数字差绝对值为1，查找第一个出现指定数字的位置，例如 1,2,3,4,5,6,7,6,5,6,7,8,9      查找7，返回6
    public static int f2(int[] arr, int target) {
        for (int i = 0; i < arr.length;) {
            if (arr[i] == target) {
                return i;
            }
            int dif = arr[i] > target ? arr[i] - target : target - arr[i];
            i += dif;
        }
        return -1;
    }
    //第三题：给定一个非负数组，该数组位置的值代表最大能跳的个数，求其是否能够调到最后一个位置。
    public static boolean f3(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len;) {
            if (arr[i] == 0 && i != arr.length-1) {
                break;
            }
            if (i + arr[i] >= arr.length-1) {
                return true;
            }
            i += arr[i];
        }
        return false;
    }
    //第四题：输入一个字符串，打印字符串的子集。
    //写函数实现，输入一个不包含重复字符的字符串，输出该字符串中字符的所有组合，
    //例如，输入abc,输出a,b,c,ab,ac,bc,abc
    public static void f4(String sb, String str) {
        if (str.length() == 0) {
            System.out.print(sb.toString() + " ");
            return;
        }
        //第n个字符串元素选不选择
        //选，截取字符串第一个元素保存，第二个参数为剩余字符串

        f4(sb + str.charAt(0), str.substring(1));
        //不选
        f4(sb, str.substring(1));




    }
    //第五题：求一个数的二进制表示中的1位的个数，例如9的二进制1001,1的个数为2
    public static int f5(int binary) {
        if (binary == 0) {
            return 0;
        }
        int count = 0;
        while (binary != 0) {
//            if ((binary & 1) == 1) {
//                ++count;
//            }
//            binary >>= 1;    //每次右移，除2
            binary = binary & (binary-1);//1000 & 0111 = 0    0111 & 0110 = 0110  0110 & 0101 = 0100  每次消除一个1;
            ++count;
        }
        return count;
    }
    /**
     * 题目描述：
     * 五个吃货在海边忙活了一天,挖了一堆生蚝，本着公平的原则，第一个吃货把这堆生蚝平均分成了五份，但是多了一个，处于生态平衡，他提出了一个规则
     * 后续都要按照五份的规则进行划分，多余的放生，于是他把多的一个放入海中，并拿走了一份，第二个吃货又把剩下的平均分成了五份，又多出了一个，他同样把多的
     * 一个扔入海中，拿走了一份，第三第四第五个吃货都是这样做的，问原来最少有多少个生蚝
     */
    public static void f6() {
        //(N-1)/5 = n(k)  k=1,2,3,4,5  n(k)为第k个人分到的生蚝，n(5)min = 1
        //int n = 1;
        for (int i = 0; i < 10000; i++) {
            int temp = i;
            for (int j = 0; j < 5; j++) {
                if (j == 0 ) {
                    if (temp%5 != 1){
                        break;
                    }else {
                        temp = temp / 5;
                    }

                }else{
                    if (4 * temp %5 != 1) {
                        break;
                    }else {
                        if (j == 4) {
                            System.out.println(temp);
                            System.out.println("原来最少" + i +"只生蚝");
                            return;
                        }
                        temp = temp / 5;
                    }

                }
            }
        }

    }

    /**
     * 题目描述
     * 将给定的数转换为字符串，原则如下：1对应 a，2对应b，…..26对应z，
     * 例如12258可以转换为"abbeh", "aveh", "abyh", "lbeh" and "lyh"，个数为5，
     * 编写一个函数，给出可以转换的不同字符串的个数。
     */
    public static int f7(int num) {
        //定义f(n)为从第n位开始翻译一个数字的计数
        //g(n)代表第n个数字是否可转换为1-9(因为不能为0) 是1 否0
        //h(n,n+1)表示第n个和n+1个数字组合是否在10到26之间

        //递归实现出现子问题 例如1和2258   12和258的翻译，递归的下一步2258的翻译又可分为2 258.自问题翻译重复
        //所以选择动态规划自下而上解决,即从结尾开始翻译数字
        if (num <= 0) {
            return 0;
        }
        return getCount(String.valueOf(num));
    }

    public static int getCount(String str) {
        int len = str.length();
        int[] counts = new int[len];//保存第i位元素翻译计数的个数
        for (int i = len-1; i >=0; --i) {
            int count = 0;
            if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
                if (i != len-1) {
                    //从尾计数，当前元素数字满足，则加上后一位元素的计数,累加至第一位
                    count += counts[i+1];
                }else {
                    //如果为最后一个数字，满足添加，count+1;
                    ++count;
                }
            }

            if (i < len-1) {//不为最后一个元素数字
                int digit = str.charAt(i)-'0';
                int digit2 = str.charAt(i+1)-'0';
                int comb = digit*10+digit2;
                if (comb >= 10 && comb <= 26) {//同理同上
                    if (i < len - 2) {
                        count += counts[i+2];
                    }else {
                        ++count;
                    }
                }
            }

            counts[i] = count;     //counts   ==>    f(n)

        }
        return counts[0];
    }

    /**
     * 题目描述：
     *
     * 小猴子下山，沿着下山的路有一排桃树，每棵树都结了一些桃子。小猴子想摘桃子，但是有一些条件需要遵守，小猴子只能沿着下山的方向走，
     * 不能回头，每颗树最多摘一个，而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子。那么小猴子最多能摘到几颗桃子呢？
     * 举例说明，比如有5棵树，分别结了10，4，5，12，8颗桃子，那么小猴子最多能摘3颗桃子，来自于结了4，5，8颗桃子的桃树。
     *
     * 输入:
     * 输入桃树的数量和每棵树的桃子数 N x1 x2 … xn
     * 输出:
     * 小猴子能摘到的最多的桃子个数
     * 输入范例:
     * 5
     * 10
     * 4
     * 5
     * 12
     * 8
     * 输出范例:
     * 3
     */
    //递归实现
    public static int fn(int[] arr) { //{10,4,5,12,8}
        //桃的最终选择的树的总桃子树一定为递增数列，如10,12   4,5,8，该递增数列一定为原序列的子序列(子序列：即为该序列每个元素的先后顺序都为原序列相同)
        //所以解题思路为找到原序列中的最长 递增 序列==>即原序列与原序列排序后序列的 最长公共子序列(公共子序列：一个序列同时为两个序列的子序列)
        //转化为求 序列arr和Arrays.sort(arr)的最长公共子序列

        //最长公共子序列性质：

        //i,j,m = 序列长度-1

        //假设公共子序列 z{0->m}  和两个原序列x{0->i}，y{0->j}
        //1.若x[i]=y[j]，z[m]=x[i]则 z{0->m-1}  仍然为x{0->i-1}，y{0->j-1}两个序列的最长子序列，长度减一
        //2.若x[i]!=y[j]，z[m]!=x[i]则 z{0->m} 为x{0->i-1}，y{0->j} 两个序列的最长子序列
        //3.若x[i]!=y[j]，z[m]!=y[i]则 z{0->m} 为x{0->i}，y{0->j-1} 两个序列的最长子序列
        //即原序列不属于公共子序列的元素，去除后，公共子序列不变

        //利用这个性质可以得出
        //x[i]=y[j]时，找出x{0->i-1}，y{0->j-1}两个序列的公共子序列，在其尾部加上x[i]或y[j]即为x{0->i}，y{0->j}的子序列, !!即子序列长度个数+1!!
        //x[i]!=y[j]时，找出x{0->i-1}，y{0->j}公共子序列和x{0->i}，y{0->j-1}的公共子序列，最长的即为最长公共子序列

        //int[] oldArr = arr;//引用赋值，随着arr而改变
        int[] oldArr = arr.clone();
        Arrays.sort(arr);//使用快排排序

        int len = arr.length;
        //定义长度为len+1的二维数组,seq[i][j]表示两个原序列oldArr{0->len-1}和arr{0->len-1}(长度均为len)的最长公共子序列的长度
        //此时对比到A序列第i-1个元素和B个序列第j-1个元素
        //i=0或j=0时，空序列时两序列的最长公共子序列seq[i][j]=0
        //
        int[][] seq = new int[len+1][len+1];
        for (int i = 1; i < len+1; i++) {
            for (int j = 1; j < len+1; j++) {
                if (oldArr[i-1] == arr[j-1]) {
                    //若元素相等，说明对比到A序列第i个元素和B个序列第j个元素相等，可以作为子序列元素，子序列长度加一
                    seq[i][j] = seq[i-1][j-1] + 1;   //现公共子序列长度等于原公共子序列长度+1
                }else {

                    seq[i][j] = Math.max(seq[i-1][j], seq[i][j-1]);
                }
            }
        }



        //最终长度保存在最后一个元素
        return seq[len][len];

    }
    public static void lcs(int i, int j, int[] arr, int[][] seq) {
        if (i == 0 || j == 0)
            return;
        if (seq[i][j] == 1){
            lcs(i-1, j-1, arr, seq);
            System.out.println(arr[i]);
        }else if (seq[i][j] == 2){
            lcs(i-1, j, arr, seq);
        }else {
            lcs(i, j-1, arr, seq);
        }
    }


    public static void main(String[] args) {
        System.out.println("f1：" + f1(-7));
        System.out.println("f2：" + f2(new int[]{1,2,3,4,5,6,7,6,5,6,7,8,9}, 7));
        System.out.println("f3：" + f3(new int[]{3,2,1,0,4}));


        System.out.print("f4：");f4(new String(), "abc");System.out.println();

        System.out.println("f5：" + f5(7));
        System.out.print("f6：");f6();

        System.out.println("f7：" + f7(12258));

        System.out.println("fn：" + fn(new int[]{10,4,5,12,8}));
        System.out.println("fn：" + fn(new int[]{4,5,8,10,12}));
    }
    /**
     * 简述题：给定一个盛有一些黑色豆子和一些白色豆子的咖啡罐以及一大堆额外的黑色豆子，重复以下过程，直至罐中仅剩一颗豆子为止。
     * 从罐中随机选取两颗豆子，如果颜色相同，就将它们都扔掉并且放入一个额外的黑色豆子，如果颜色不同，就将白色的豆子放回罐中，
     * 而将黑色的豆子扔掉。证明该过程会终止。最后留在罐中的豆子颜色与最初的罐中的白色豆子和黑色豆子的数量有什么数学关系。
     */

    //两白：黑+1    白-2
    //两黑：黑-1    白0
    //一黑一白：黑-1  白0
    //白球成对偶数减少，如果白球总数为奇数，剩下的为白球，总数为偶数，剩下的为黑球
}
