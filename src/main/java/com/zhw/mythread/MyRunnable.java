package com.zhw.mythread;

public class MyRunnable implements Runnable {
	
	/**
	 * 正在执行的任务数
	 */
	private int num;
	
	public MyRunnable(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("正在执行的任务数： " + num);
		try {
			Thread.currentThread().sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("MyRunnable " + num + " 执行完毕");
		
	}

}
