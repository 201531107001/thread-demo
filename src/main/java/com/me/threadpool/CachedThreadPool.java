package com.me.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可动态创建线程的线程池，如果一个线程60秒内没有使用，就destroy它
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
