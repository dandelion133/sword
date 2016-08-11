package com.swordoffer;

import java.util.Stack;

public class T22 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		
		
		boolean rst = false;
		if(pushA != null && popA != null) {
			Stack<Integer> stack = new Stack<Integer>();
			int pushIndex = 0;
			for (int i = 0; i < pushA.length; i++) {
				stack.push(pushA[i]);
				while(!stack.isEmpty() && stack.peek() == popA[pushIndex]) {
					stack.pop();
					pushIndex ++;
				}
			}
			rst = stack.isEmpty();
		}
		
		return rst;

	}
}
