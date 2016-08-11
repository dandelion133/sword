package com.swordoffer;

import java.util.Stack;

public class T21 {
	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	public void push(int node) {
		data.push(node);
		if(min.isEmpty()) {
			min.push(node);
		} else {

			int top = min.peek();
			
			if(top < node) {
				min.push(top);
			} else {
				min.push(node);
			}
		}
		
	}

	public void pop() {
		if(!data.isEmpty()) {
			data.pop();
			min.pop();
		}
	}

	public int top() {
		return data.peek();

	}

	public int min() {
		if(min.isEmpty())
			return 0;
		else
			return min.peek();

	}
}
