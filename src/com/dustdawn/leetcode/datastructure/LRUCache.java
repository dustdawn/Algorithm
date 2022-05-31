package com.dustdawn.leetcode.datastructure;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (Least Recently Used最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 *
 * @author dustdawn
 * @date 2022/5/15 16:21
 */
public class LRUCache {
    /**
     * key到(key, val)的映射，用于快速定位双链表节点元素
     */
    private HashMap<Integer, Node> map;
    /**
     * 双链表结构，添加删除O(1)时间复杂度
     * 靠近尾部的元素即为最近使用的，靠近头部的元素为最久未使用的
     */
    private DoubleList cache;
    /**
     * 最大容量
     */
    private int capacity;

    /**
     * LRU算法（Least Recently Used）
     * 每次淘汰最久没有使用的数据
     * 核心数据结构：LinkedHashMap（此处借助双链表和HashMap实现），链表有序性维护插入顺序，借助哈希映射以O(1)时复快速访问元素
     * 构造容量为capacity的缓存
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 将某个key提升为最近使用的
     *
     * @param key
     */
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    /**
     * 添加最近使用的元素
     *
     * @param key
     * @param val
     */
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        // 添加key和双链表节点的映射
        map.put(key, node);
    }

    /**
     * 删除某一个key
     *
     * @param key
     */
    private void deleteKey(int key) {
        Node node = map.get(key);
        // 从链表中删除
        cache.remove(node);
        // 从映射中删除
        map.remove(key);
    }

    /**
     * 删除最久未使用的元素
     */
    private void removeLeastRecently() {
        // 链表头部的第一个元素即为最久未使用的
        Node deleteNode = cache.removeFirst();
        // 从map中删除key
        map.remove(deleteNode.key);
    }

    /**
     * 在缓存中查询key
     *
     * @param key
     * @return
     */
    public int get(int key) {
        // 不存在返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    /**
     * 将key和value存入缓存
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        /*
        如key已存在，修改val并将key提升为最近使用
        如key不存在，容量未满时，添加至尾部；容量满时，删除最久未使用的key
         */
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (capacity == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    /**
     * 通过LinkedHashMap实现
     */
    private LinkedHashMap<Integer, Integer> cacheLHM = new LinkedHashMap<>();

    public int getByLHM(int key) {
        if (!cacheLHM.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cacheLHM.get(key);
    }

    public void putByLHM(int key, int value) {
        if (cacheLHM.containsKey(key)) {
            cacheLHM.put(key, value);
            makeRecently(key);
            return;
        }
        if (cacheLHM.size() >= this.capacity) {
            int oldestKey = cacheLHM.keySet().iterator().next();
            cacheLHM.remove(oldestKey);
        }
        cacheLHM.put(key, value);
    }

    private void makeRecentlyByLHM(int key) {
        int value = cacheLHM.get(key);
        cacheLHM.remove(key);
        cacheLHM.put(key, value);
    }


    public static void main(String[] args) {
        /**
         * 输入
         * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
         * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
         * 输出
         * [null, null, null, 1, null, -1, null, -1, 3, 4]
         *
         * 解释
         * LRUCache lRUCache = new LRUCache(2);
         * lRUCache.put(1, 1); // 缓存是 {1=1}
         * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
         * lRUCache.get(1);    // 返回 1
         * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
         * lRUCache.get(2);    // 返回 -1 (未找到)
         * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
         * lRUCache.get(1);    // 返回 -1 (未找到)
         * lRUCache.get(3);    // 返回 3
         * lRUCache.get(4);    // 返回 4
         */
    }
}
