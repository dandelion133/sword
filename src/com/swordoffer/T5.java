package com.swordoffer;

import java.util.Stack;

public class T5 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    boolean isPop = false;//±êÖ¾Î»
    public void push(int node) {
        if(stack1.size() == 0 && stack2.size() == 0) {
        	stack1.push(node);        	
        } else if(stack1.size() == 0) {
        	stack2.push(node); 
        } else if(stack2.size() == 0) {
        	stack1.push(node); 
        }
        isPop = false;
    }
    
    public int pop() {
    	
    	if(stack1.size() == 0 && stack2.size() == 0) {
        	return 0;      	
        } else if(stack1.size() == 0) {
        	if(isPop) {
        		return stack2.pop();
        	} else {
        		isPop = true;
        		while(stack2.size() > 0) {
            		stack1.push(stack2.pop());
            	}
            	return stack1.pop();
        	}
        	
        } else if(stack2.size() == 0) {
        	
        	if(isPop) {
        		return stack1.pop();
        	} else {
        		isPop = true;
        		while(stack1.size() > 0) {
            		stack2.push(stack1.pop());
            	}
            	return stack2.pop();
        	}
        	
        	
        }
    	
    	
    	return 0;
    
    }
    
    
    public static void main(String[] args) {
		T5 t5 = new T5();
		t5.push(0);
		t5.push(1);
		t5.push(2);
		t5.push(3);
		
		System.out.println(t5.pop());
		System.out.println(t5.pop());
		System.out.println(t5.pop());
		System.out.println(t5.pop());
		
		t5.push(4);
		System.out.println(t5.pop());
		
	}
    
}
