package com.dustdawn.leetcode.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 * 实现扁平迭代器类 NestedIterator ：
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 提示：
 * 1 <= nestedList.length <= 500
 * 嵌套列表中的整数值在范围 [-106, 106] 内
 *
 * @author dustdawn
 * @date 2022/5/29 14:41
 */
public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> list;

    /**
     * NestedInteger扁平化等价于遍历一颗N叉树的所有“叶子节点”
     *
     * @param nestedList
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        // 存放将nestedList打平的结果
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        // hasNext方法保证了第一个元素一定是整数类型
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        // 循环拆分列表元素，直到列表第一个元素是整数类型
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            // 当列表第一个元素时列表类型时，进入循环
            List<NestedInteger> first = this.list.remove(0).getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }

    @Override
    public void remove() {

    }

    public static void main(String[] args) {
        /**
         * 示例 1：
         *
         * 输入：nestedList = [[1,1],2,[1,1]]
         * 输出：[1,1,2,1,1]
         * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
         * 示例 2：
         *
         * 输入：nestedList = [1,[4,[6]]]
         * 输出：[1,4,6]
         * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
         */
    }
}
