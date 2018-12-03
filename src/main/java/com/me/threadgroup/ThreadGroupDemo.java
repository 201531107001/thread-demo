package com.me.threadgroup;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Random;

public class ThreadGroupDemo {

	public static void main(String[] args) throws InterruptedException {
		// 创建5个线程，并入group里面进行管理
		ThreadGroup threadGroup = new ThreadGroup("threadGroupTest");
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(threadGroup, () -> {
				System.out.println("Thread Start " + Thread.currentThread().getName());
				try {
					int value = (int) new Random((new Date()).getTime()).nextDouble() * 100;
					System.out.printf("Thread %s doTask: %d\n", Thread.currentThread().getName(), value);
					TimeUnit.SECONDS.sleep(value);
				} catch (InterruptedException e) {
					System.out.printf("Thread %s: Interrupted\n", Thread.currentThread().getName());
					return;
				}
				System.out.println("Thread end " + Thread.currentThread().getName());
			});
			thread.start();
			//TimeUnit.SECONDS.sleep(1);
		}
		
		// group信息
		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
		System.out.printf("Information about the Thread Group\n");
		threadGroup.list();

		System.out.println("---------------------------------------");
		
		// 复制group的thread信息
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);
		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
		}
		
		System.out.println("-------------------------------------");
		// 等待结束
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 中断group中的线程
		threadGroup.interrupt();
	}
}