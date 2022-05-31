package com.dustdawn.leetcode.datastructure;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU 缓存
 * 请你为 最不经常使用（LFU：Least Frequently Used）缓存算法设计并实现数据结构。
 * 实现 LFUCache 类：
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 提示：
 * 0 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * 最多调用 2 * 105 次 get 和 put 方法
 *
 * @author dustdawn
 * @date 2022/5/31 21:30
 */
public class LFUCache {
    /**
     * key到val的映射，KV表
     */
    HashMap<Integer, Integer> keyToVal;
    /**
     * key到freq的映射，KF表
     */
    HashMap<Integer, Integer> keyToFreq;
    /**
     * freq到key列表的映射，FK表
     * LFU核心：
     * 1.freq到key的映射
     * 2.将freq最小的key删除，需要O(1)复杂度通过变量minFreq最快找到一个freq对应一个key的列表
     * 3.有多个key对应一个freq，freq对key为一对多的关系，即一个freq对应一个key的列表
     * 4.freq对应的key 的列表应该存在时序，便于快速查找并删除最旧的key
     * 5.能够做到快速删除key列表中的任何一个key：因为频次为freq的某个key被访问，那么他的频次变为freq+1，就应该从freq对应的key列表中删除
     * LinkedHashSet能满足3,4,5的要求，同时链表保证插入具有时序，Hash保证对元素快速访问和删除
     */
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    /**
     * 记录最小的频次
     */
    int minFreq;
    /**
     * 记录LFU缓存的最大容量
     */
    int capacity;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    /**
     * 返回key对应的val，然后增加key对应的freq
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 增加key对应的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    /**
     * 添加key val
     * 如key已存在，修改key对应的val，增加key对应的freq
     * 如key不存在，如容量未满，插入key和val，key对应的freq为1
     * 如容量已满，淘汰freq最小的key，再同上操作
     *
     * @param key
     * @param val
     */
    public void put(int key, int val) {
        if (this.capacity <= 0) {
            return;
        }
        // 若key存在，修改对应val即可
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            // key对应的freq+1
            increaseFreq(key);
            return;
        }

        // 若key不存在，需要插入
        // 若容量已满，淘汰一个freq最小的key
        if (this.capacity <= keyToVal.size()) {
            removeMinFreqKey();
        }

        // 插入key和val，对应的freq为1
        // 插入KV表
        keyToVal.put(key, val);
        // 插入KF表
        keyToFreq.put(key, 1);
        // 插入FK表
        if (!freqToKeys.containsKey(1)) {
            freqToKeys.put(1, new LinkedHashSet<Integer>());
        }
        freqToKeys.get(1).add(key);
        // 插入新key后最小的freq肯定是1
        this.minFreq = 1;
    }

    /**
     * 淘汰最小freq的key
     */
    private void removeMinFreqKey() {
        // freq对应的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        // 其中最先插入的那个key就是该被淘汰的key
        int deletedKey = keyList.iterator().next();
        // 更新FK表
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            // 如果删除该key后，freq对应的key列表为空，则FK表可移除该freq
            freqToKeys.remove(this.minFreq);
            // 因为removeMinFreqKey方法只有在put方法中插入新key时调用，最后minFreq更新为了1，所以这里minFreq变了也不需要处理
        }
        // 更新KV表
        keyToVal.remove(deletedKey);
        // 更新KF表
        keyToFreq.remove(deletedKey);
    }

    /**
     * 增加key对应的freq
     *
     * @param key
     */
    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        // 更新KF表
        keyToFreq.put(key, freq + 1);
        //更新FK表
        //将key从freq对应的key列表中删除
        if (freqToKeys.containsKey(freq)) {
            freqToKeys.get(freq).remove(key);
        }
        // 将key加入freq+1对应的列表中
        if (!freqToKeys.containsKey(freq + 1)) {
            freqToKeys.put(freq + 1, new LinkedHashSet<Integer>());
        }
        freqToKeys.get(freq + 1).add(key);
        // 如果freq对应的列表空了，移除这个freq
        if (freqToKeys.containsKey(freq) && freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            // 如果这个freq恰好是minFreq，更新minFreq
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 示例：
         *
         * 输入：
         * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
         * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
         * 输出：
         * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
         *
         * 解释：
         * // cnt(x) = 键 x 的使用计数
         * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
         * LFUCache lfu = new LFUCache(2);
         * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
         * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
         * lfu.get(1);      // 返回 1
         *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
         * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
         *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
         * lfu.get(2);      // 返回 -1（未找到）
         * lfu.get(3);      // 返回 3
         *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
         * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
         *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
         * lfu.get(1);      // 返回 -1（未找到）
         * lfu.get(3);      // 返回 3
         *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
         * lfu.get(4);      // 返回 4
         *                  // cache=[3,4], cnt(4)=2, cnt(3)=3
         */
    }
}
