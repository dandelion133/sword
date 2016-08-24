package com.swordoffer;
/**
 * http://www.cnblogs.com/nailperry/p/4752987.html
 * 
 * 具体参考博客
 * @author QHF
 *
 */
public class T32 {
	public int NumberOf1Between1AndN_Solution(int n) {
		
		int calc = calc(n,1);
		
		return calc;
	    
    }
	
	
	public int calc(int n,int x) {
		
		if(n < 0 || x < 1 || x > 9) return 0;
		
		
		int high = n;
		int tmp = 0;
		
		
		int curr = 0;
		int low = 0;
		
		int total = 0;
		
		int i = 1;
		while(high != 0) {
			high = n / (int)Math.pow(10, i);// 获取第i位的高位
			tmp = n % (int)Math.pow(10, i);
			
			curr = tmp / (int)Math.pow(10, i - 1);// 获取第i位
			low = tmp % (int)Math.pow(10, i - 1);// 获取第i位的低位
			
			if(curr == x) {
				total += high * (int)Math.pow(10, i - 1) + low + 1;
			} else if(curr > x) {
				total += (high + 1)  * (int)Math.pow(10, i - 1);
			} else {
				total += (high)  * (int)Math.pow(10, i - 1);
			}
			i ++;
			
			
		}
		
		
		
		return total;
	    
    }
	
	public static void main(String[] args) {
		T32 t32 = new T32();
		System.out.println(t32.NumberOf1Between1AndN_Solution(12));
		;
	}
}
