package com.swordoffer;

public class Singleton {
	private static volatile Singleton instance;
	//构造方法私有化
	private Singleton() {
		
	}
	//对外开放的静态方法
	public static Singleton getInstance() {
		return SingletonHoler.instance;
		
	}
	
	private static class SingletonHoler {
		private static final Singleton instance = new Singleton();
	}
	
	
	/*public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}*/
	
/*	
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}*/
	
	
	
}
