package com.dustdawn.mianshi;
/**
 * 回文数  (判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。)
 * @author DUSTDAWN
 *反转一半
 */
public class Solution_3 {
	public static void main(String args[]) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(0));
	}
	public static boolean isPalindrome(int x) {
        if(x<0||x%10==0&&x!=0) {
            return false;
        }
        int revered = 0;
        while(x>revered) {
        	int pop = x%10;
        	revered = pop + revered*10;
        	x/=10;
        }
        return x==revered||x==revered/10;
    }
}
