package com.dustdawn.stringFun;

/**
 * @author dustdawn
 * @date 2019/9/9 10:59
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * 求给定字符串中最长无重复子字符串的长度
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        HashSet<Character> set = new HashSet<Character>();
        //[i, j)的滑动窗口
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans = Math.max(ans, j-i+1);
                ++j;
            }else {
                set.remove(s.charAt(i));
                ++i;
            }
        }
        return ans;
    }

    /*
     * 思路： 使用HashMap存放{字符-索引}的映射，当我们发现重复的字符时，直接跳过这些字符。
     * 通过遍历j来循环。如果遍历到j时，s[i,j)中有重复元素s[j]，我们不再一点一点移动i的位置了，
     * 若重复元素角标为j'，直接跳过[i,j′]这个区间即可，直接将i赋值为j'+1。
     *
     */

    public static int lengthOfLongestSubstringII(String s) {
        int ans =0, n = s.length();
        HashMap<Character, Integer> map = new HashMap();

        for (int i = 0, j =0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ppwwkew"));
        System.out.println(lengthOfLongestSubstringII("ppwwkew"));
    }
}
