package com.dust.acmcoder;

/**
 * @author dustdawn
 * @date 2019/9/14 21:08
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，
 * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class maxInWindows {
    LinkedList<Integer> list = new LinkedList<>();
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (size > num.length || size <= 0) {
            return arrayList;
        }
        //思路，利用队列保存进入滑动窗口内部的元素位置(如新元素小于队列尾保存索引对应的元素，则直接将元素索引入队，
        // 反之出队尾元素索引，将该元素索引入队)保证队列从大到小排列
        int result[] = new int[num.length-size+1]; //数组长度-窗口大小+1 = 窗口个数
        for (int i = 0; i < num.length; i++) {
            while (!list.isEmpty() && num[list.peekLast()] < num[i]) {
                list.pollLast();//如果当前元素大于队尾元素，则尾出队列索引
            }
            list.addLast(i);//直接入队

            //size-1为第一个窗口的右端元素序号
            //当队列头保存索引和当前索引差大于滑动窗口宽度后，
            //即滑动窗口满后，删除旧元素索引
            if (i- list.peek() >= size) {
                list.poll();
            }
            if (i- (size - 1) >= 0) {//窗口刚满或窗口移动时，取出队列中保存的最大索引
                result[i-size+1] = num[list.peek()];
            }
        }

        for (int i : result) {
            arrayList.add(i);
        }

        return arrayList;
    }


    public static void main(String[] args) {
        System.out.println(new maxInWindows().maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3).toString());
        System.out.println(new maxInWindows().maxInWindows(new int[]{10,14,12,11}, 2).toString());
    }
}
