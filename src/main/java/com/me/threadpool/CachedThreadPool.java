package com.me.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可动态创建线程的线程池，如果一个线程60秒内没有使用，就destroy它
 * 执行任务的线程数量是无限的，重要有任务，就会创建线程去执行任务，准确的说最多为Integer.MAX_VALUE
 * 使用SynchronousQueue队列实现任务的存储，只能存储一个任务，它必须有线程消耗掉才会存储另一个任务
 * @author gqm
 *
 */
public class CachedThreadPool {
	
	public static void main(String[] args) {
		//创建线程的线程池
		ExecutorService service = Executors.newCachedThreadPool();
		 
		service.execute(new PrintTask("a"));
		service.execute(new PrintTask("b"));
		service.execute(new PrintTask("c"));
		service.execute(new PrintTask("d"));
		service.execute(new PrintTask("e"));
		service.execute(new PrintTask("f"));
		
		service.shutdown();
	}
}
