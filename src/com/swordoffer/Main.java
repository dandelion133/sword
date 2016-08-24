package com.swordoffer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
	private static HashMap<String, BigInteger> map;

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches()) {
			return false;
		}
		return true;
	}  
	  
	public static void main(String[] args) {
		
		Scanner cin=new Scanner(System.in); 
	//	while(cin.hasNextLine()) {
			ArrayList<String> list = new ArrayList<String>();
			String line = cin.next();
			System.out.println(line);
			String[] split = line.split("\\s+");
			for (String string : split) {
				if(!list.contains(string)) {
					list.add(string);
				}
			}
			
			System.out.println(list.size());
	//	}	
		
	
        
	}
	private static boolean isEnglish(char word) {   
      
            if (!(word >= 'A' && word <= 'Z')  
                    && !(word >= 'a' && word <= 'z')) {  
                return false;  
            }  
          
        return true;  
    }
	/**
	 * 将字符串转化成List
	 * @param str
	 * @return
	 */
	public static ArrayList<String> getStringList(String str){
		ArrayList<String> result = new ArrayList<String>();
		String num = "";
		String var = "";
		char lastChar = 'a';
		boolean isNative = false;
		for (int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i)) || isEnglish(str.charAt(i))){
				if(Character.isDigit(str.charAt(i)))
					num = num + str.charAt(i);
				else if(isEnglish(str.charAt(i))) {
					var = var + str.charAt(i);
				} 
				
			} 
			else {
				
				if(str.charAt(i) == '-' && !Character.isDigit(lastChar)) {
					
					isNative = true;
				} else{
					if(num != ""){
						if(isNative) {
							result.add("(");
							result.add("0");
							result.add("-");
							result.add(num);
							result.add(")");
						}else
						result.add(num);
						isNative = false;
					}
					if(var != "") {
						BigInteger r = map.get(var);
						long longValue = r.divide(r.abs()).longValue();
						BigInteger r2 = r.multiply(BigInteger.valueOf(longValue));
						if(longValue < 0) {
							result.add("(");
							result.add("0");
							result.add("-");
							result.add(r2+ "");
							result.add(")");
						} else {
							result.add(map.get(var) + "");
						}
						
					}
					
					result.add(str.charAt(i) + "");
					num = "";
					var = "";
				}
				
				
				
				
			}
			
			
			lastChar = str.charAt(i);
			
		}
		if(num != ""){
			if(isNative) {
				result.add("(");
				result.add("0");
				result.add("-");
				result.add(num);
				result.add(")");
			}else
			result.add(num);
			isNative = false;
		}
		if(var != "") {
			
			BigInteger r = map.get(var);
			long longValue = r.divide(r.abs()).longValue();
			BigInteger r2 = r.multiply(BigInteger.valueOf(longValue));
			if(longValue < 0) {
				result.add("(");
				result.add("0");
				result.add("-");
				result.add(r2+ "");
				result.add(")");
			} else {
				result.add(map.get(var) + "");
			}
		}
		return result;
	}
	
	/**
	 * 将中缀表达式转化为后缀表达式
	 * @param inOrderList
	 * @return
	 */
	public static ArrayList<String> getPostOrder(ArrayList<String> inOrderList){
		
		ArrayList<String> result = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < inOrderList.size(); i++) {
			if(Character.isDigit(inOrderList.get(i).charAt(0))){
				result.add(inOrderList.get(i));
			}else{
				switch (inOrderList.get(i).charAt(0)) {
				case '(':
					stack.push(inOrderList.get(i));
					break;
				case ')':
					while (!stack.peek().equals("(")) {
						result.add(stack.pop());
					}
					stack.pop();
					break;
				default:
					while (!stack.isEmpty() && compare(stack.peek(), inOrderList.get(i))){
						result.add(stack.pop());
					}
					stack.push(inOrderList.get(i));
					break;
				}
			}
		}
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}
		return result;
	}
	
	/**
	 * 计算后缀表达式
	 * @param postOrder
	 * @return
	 */
	public static BigInteger calculate(ArrayList<String> postOrder){
		Stack<BigInteger> stack = new Stack<BigInteger>();
		for (int i = 0; i < postOrder.size(); i++) {
			if(Character.isDigit(postOrder.get(i).charAt(0))){
				stack.push(BigInteger.valueOf(Long.parseLong(postOrder.get(i))));
				
				
				
				
			}else{
				BigInteger back = (BigInteger)stack.pop();
				BigInteger front = (BigInteger)stack.pop();
				BigInteger res = BigInteger.valueOf(0l);
				switch (postOrder.get(i).charAt(0)) {
				case '+':
					res = front.add(back);
					break;
				case '-':
					res = front.subtract(back);
					break;
				case '*':
					res = front.multiply(back);
					break;
				
				}
				stack.push(res);
			}
		}
		return (BigInteger)stack.pop();
	}
	
	/**
	 * 比较运算符等级
	 * @param peek
	 * @param cur
	 * @return
	 */
	public static boolean compare(String peek, String cur){
		if("*".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){
			return true;
		}else if("/".equals(peek) && ("/".equals(cur) || "*".equals(cur) ||"+".equals(cur) ||"-".equals(cur))){
			return true;
		}else if("+".equals(peek) && ("+".equals(cur) || "-".equals(cur))){
			return true;
		}else if("-".equals(peek) && ("+".equals(cur) || "-".equals(cur))){
			return true;
		}
		return false;
	}


     
}
