package com.dustdawn.mianshi;
/**
 * 整数反转		(给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。)
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author DUSTDAWN
 *
 */
public class Solution_2 {
	public static void main(String[] args) {
		
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(Integer.MAX_VALUE));
	}
	public static int reverse(int x) {
		int rev = 0;
		
		while(x!=0) {
			int pop = x%10;
			rev = pop + rev*10;
			x/=10;
			if(rev>Integer.MAX_VALUE/10||(rev == Integer.MAX_VALUE/10&&pop>7)) return 0;
            if(rev<Integer.MIN_VALUE/10||(rev == Integer.MIN_VALUE/10&&pop<-8)) return 0;
		}
			return rev;
		
				
	}
}
