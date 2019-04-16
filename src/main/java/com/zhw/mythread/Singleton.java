package com.zhw.mythread;

/**
 *  饿汉式,兼顾线程安全和效率的写法 <br>
 * @author zhanghongwei
 *
 */
public class Singleton {
	
	private static volatile Singleton singleton = null;
	
	private Singleton() {}
	
	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
		
	}

}
