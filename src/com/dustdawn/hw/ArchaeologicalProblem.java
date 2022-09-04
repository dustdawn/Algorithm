package com.dustdawn.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 考古问题
 * 题目描述
 * 考古问题，假设以前的石碑被打碎成了很多块，每块上面都有一个或若干个字符，
 * 请你写个程序来把之前石碑上文字可能的组合全部写出来，按升序进行排列。
 *
 * @author dustdawn
 * @date 2022/9/4 15:46
 */
public class ArchaeologicalProblem {
    /**
     * 示例
     * 输入
     * 3
     * a b c
     * 输出
     * abc
     * acb
     * bac
     * bca
     * cab
     * cba
     * 输入
     * 3
     * a a b
     * 输出
     * aab
     * aba
     * baa
     * 思路分析
     * 这道题是全排列问题，是含有重复元素的全排列的问题，按任意顺序返回所有不重复的全排列。
     * 典型的回溯算法，回溯算法的重点是剪枝，在遍历的过程中，一边遍历一遍检测，在一定会产生重复结果集的地方剪枝。
     * 如果要比较两个列表是否一样，一个容易想到的办法是对列表分别排序，然后逐个比对。既然要排序，
     * 我们就可以在搜索之前就对候选数组排序，一旦发现某个分支搜索下去可能搜索到重复的元素就停止搜索，
     * 这样结果集中不会包含重复列表。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");
        Arrays.sort(arr);
        boolean[] vis = new boolean[arr.length];
        backtrack(0, "", arr, vis);
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static List<String> res = new ArrayList<>();

    public static void backtrack(int len, String s, String[] arr, boolean[] vis) {
        if (len == arr.length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (vis[i] || i > 0 && arr[i].equals(arr[i - 1]) && !vis[i - 1]) {
                continue;
            }
            vis[i] = true;
            backtrack(len + 1, s + arr[i], arr, vis);
            vis[i] = false;
        }
    }
}
