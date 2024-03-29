package com.dustdawn.leetcode.binarysearch;

/**
 * 278. 第一个错误的版本
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * @author dustdawn
 * @date 2022/2/26 18:00
 */
public class FirstBadVersion {
    /**
     * 锁定左侧边界的二分搜索
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // 答案在区间 [left, mid] 中
                right = mid - 1;
            } else {
                // 答案在区间 [mid + 1, right] 中
                left = mid + 1;
            }
        }
        // 跳出循环条件 right = mid - 1小于left，之前的上一个right值即为最小右侧，即当前right + 1值或当前left值
        return left;
    }

    /**
     * 示例 1：
     *
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     * 示例 2：
     *
     * 输入：n = 1, bad = 1
     * 输出：1
     * @param i
     * @return
     */
    private boolean isBadVersion(int i) {
        return false;
    }
}
