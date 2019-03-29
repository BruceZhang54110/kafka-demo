package com.zhw.mythread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	/**
	 * 池中所保存的线程数，包括空闲线程
	 */
	final static int corePoolSize = 5;
	
	/**
	 * 允许最大线程数
	 */
	final static int maxmumPoolSize = 10;
	
	/**
	 * 当线程数大于核心线程时，此为终止多余的空闲线程等待新任务的最长时间
	 */
	final static long keepAliveTime = 200;
	
	/**
	 * 任务缓存队列
	 */
	final static ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
				corePoolSize, maxmumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue);
		for (int i = 0; i < 16; i++) {
			MyRunnable myRunnable = new MyRunnable(i);
			threadPoolExecutor.execute(myRunnable);
			System.out.println(i + ", 线程池中现在的线程数目 ：" + threadPoolExecutor.getPoolSize() + ", 队列中等待任务量： " + threadPoolExecutor.getQueue().size());
		}
		threadPoolExecutor.shutdown();
	}
	
	
}
