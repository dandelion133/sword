package com.swordoffer;


import java.util.*;

public class T35 {
	
	public int findIndex(String str) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		//String str = scanner.nextLine();
		
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				
				map.put(array[i], map.get(array[i]) + 1);
				
			} else {
				map.put(array[i], 1);
			}
		}
		/*Iterator<Character> iterator = map.keySet().iterator();
		
		while(iterator.hasNext()) {
			Character key = iterator.next();
			Integer integer = map.get(key);
			System.out.println("key: " + key + ",value: " + integer);
		}*/
		
		
		for (int i = 0; i < str.length(); i++) {
			if(map.get(str.charAt(i))==1) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		T35 m = new T35();
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			int index = m.findIndex(str);
			System.out.println(str.charAt(index));
			
		}
		
		
	}
}
