package com.qian;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static String regex = "\\s";
	public static void main(String[] args) throws Exception {
		
		byte b1 = 1,b2 = 2,b3,b6;
		final byte b4 = 4,b5 = 6;
		b6 = b4 + b5;
		b3 = (byte)(b1 + b2);
		System.out.println(b3 + b6);
		
		
		Set<String> set = new HashSet<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 50; i++) {
			if (in.ready()) {
				String text = in.readLine();
				String[] arr = text.split(regex);
				for (String val : arr) {
					set.add(val);
				}
			} else {
				break;
			}
		}
		System.out.println(set.size());
		in.close();
		
		
		
		
		
		
		
		
		
		
		/*Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (!"".equals(str)) {
            	
            	String[] split = str.split(" ");
            	for (String string : split) {
            		System.out.println(string);
				}
            	
                
            } else {
                break;
            }
        }*/

/*
		HashSet<String> set = new HashSet<>();
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String temp = in.nextLine();
			String[] array = temp.split(" ");
			for (String a : array) {
				set.add(a);
			}
		}
		while (in.hasNext()) {
			set.add(in.next());
		}
		in.close();
		int count = set.size();
		System.out.println(count);*/
      
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	String str = getStreamString(System.in);
		
		System.out.println(str);
		BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a line:");
		int s;
		try {
			
			while((s = stdin.readLine()) != null) {
				System.out.println(s);
			}
			while((s = stdin.read()) != -1) {
				System.out.print((char)s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} */
	}
	
	
	/**
	* 将一个字符串转化为输入流
	*/
	public static InputStream getStringStream(String sInputString) {
		if (sInputString != null && !sInputString.trim().equals("")) {
			try{
				ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
				return tInputStringStream;
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
		return null;
	}
		
	
	
	/**
	* 将一个输入流转化为字符串
	*/
	public static String getStreamString(InputStream tInputStream) {
		if (tInputStream != null) {
			try {
				BufferedReader tBufferedReader = new BufferedReader(
						new InputStreamReader(tInputStream));
				StringBuffer tStringBuffer = new StringBuffer();
				String sTempOneLine = new String("");
				while ((sTempOneLine = tBufferedReader.readLine()) != null) {
					tStringBuffer.append(sTempOneLine);
				}
				return tStringBuffer.toString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

}

