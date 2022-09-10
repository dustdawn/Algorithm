package com.dustdawn.hw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 火星文计算(200分)(运算符+双栈)
 * 已知火星人使用的运算符为#、$，其与地球人的等价公式如下：
 * x#y = 2*x+3*y+4
 * x$y = 3*x+y+2
 * 1、其中x、y是无符号整数
 * 2、地球人公式按C语言规则计算
 * 3、火星人公式中，$的优先级高于#，相同的运算符，按从左到右的顺序计算
 * 现有一段火星人的字符串报文，请你来翻译并计算结果。
 * 输入描述:
 * 火星人字符串表达式（结尾不带回车换行）
 * 输入的字符串说明：  字符串为仅由无符号整数和操作符（#、$）组成的计算表达式。
 * 例如：123#4$5#67$78。
 * 1、用例保证字符串中，操作数与操作符之间没有任何分隔符。
 * 2、用例保证操作数取值范围为32位无符号整数。
 * 3、保证输入以及计算结果不会出现整型溢出。
 * 4、保证输入的字符串为合法的求值报文，例如：123#4$5#67$78
 * 5、保证不会出现非法的求值报文，例如类似这样字符串：
 * #4$5 //缺少操作数
 * 4$5# //缺少操作数
 * 4#$5 //缺少操作数
 * 4 $5 //有空格
 * 3+4-5*6/7 //有其它操作符
 * 12345678987654321$54321 //32位整数计算溢出
 * 输出描述:
 * 根据输入的火星人字符串输出计算结果（结尾不带回车换行）
 *
 * @author dustdawn
 * @date 2022/9/10 15:16
 */
public class H_Martian {
    public static int jinghao(int x, int y) {
        return 2 * x + 3 * y + 4;
    }

    public static int daole(int x, int y) {
        return 3 * x + y + 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> fuhao = new ArrayDeque<>();
        String str = "";    //用来保存数字字符串
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                str += s.charAt(i);   //考虑到多位数需要拼接
                if (i == s.length() - 1) {    //最后一个字符
                    int n = Integer.valueOf(str);   //最后一个肯定是数字
                    char f = fuhao.peek();
                    if (f == '#') {
                        num.push(n);    //如果是#则表示不计算
                    } else {
                        int m = num.pop();
                        fuhao.pop();
                        num.push(daole(m, n));   //如果是$进行计算
                    }
                }
            } else {
                if (fuhao.isEmpty()) {
                    num.push(Integer.valueOf(str)); //上个str数字化push数字堆栈
                    str = "";   //重置str
                    fuhao.push(s.charAt(i));    //本次字符串push符合堆栈
                } else {
                    int n = Integer.valueOf(str);   //str数字化
                    char f = fuhao.peek();  //获取符号堆栈最上面的符号
                    str = "";   //重置str
                    if (f == '#') {
                        num.push(n);    //#先不计算
                    } else {
                        int m = num.pop();  //获取数字堆栈最上面的数字
                        fuhao.pop();    //移除符号堆栈最上面的符号
                        num.push(daole(m, n));   //计算完push数字堆栈
                    }
                    fuhao.push(s.charAt(i));    //将本次的符号push符号堆栈
                }
            }
        }
        int n = num.size();
        while (n > 1) {
            num.addLast(jinghao(num.pollLast(), num.pollLast()));    //剩下的数字直接进行#运算
            n--;
        }

        System.out.println(num.peek());
        /**
         * 示例1
         *
         * 输入
         *
         * 7#6$5#12
         *
         * 输出
         *
         * 226
         *
         * 说明
         * 7#6$5#12
         * =7#(3*6+5+2)#12
         * =7#25#12
         * =(2*7+3*25+4)#12
         * =93#12
         * =2*93+3*12+4
         * =226  
         */
    }
}
