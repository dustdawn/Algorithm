package com.dustdawn.leetcode.datastructure;

import java.util.List;

/**
 * N叉树
 * @author dustdawn
 * @date 2022/5/29 14:38
 */
public class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    /**
     * 存的是整数返回true
     *
     * @return
     */
    public boolean isInteger() {
        return val != null;
    }

    public Integer getInteger() {
        return this.val;
    }

    public List<NestedInteger> getList() {
        return this.list;
    }
}
