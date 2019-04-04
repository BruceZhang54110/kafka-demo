package com.zhw.mythread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownlatchTest implements Runnable {
	
	static final CountDownLatch cdl = new CountDownLatch(1);
	static final CountDownlatchTest cdle = new CountDownlatchTest();

	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(10) * 1000);
			System.out.println(Thread.currentThread().getName() + " 部分检查完毕。。。");
			// 一个线程完成工作,倒计时器减1
			cdl.countDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			exec.submit(cdle);
		}
		cdl.await();
		System.out.println("所有检查完毕...可以起飞");
		exec.shutdown();
	}

}
